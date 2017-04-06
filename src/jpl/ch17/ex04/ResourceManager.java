package jpl.ch17.ex04;

import java.io.File;

/**
 * 2017.4.2
 * Reference<?> ref = new PhantomReference<Object>(key, queue);
 * で、keyオブジェクトがファントム参照になれば、GCがqueue（参照キュー）に入れるようになっているらしい。
 */

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class ResourceManager {

	final ReferenceQueue<Object> queue;
	final Map<Reference<?>, Resource> refs;
	final Thread reaper;
	boolean shutdown = false;
	
	public ResourceManager() {
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>, Resource>();
		reaper = new ReaperThread();
		reaper.start();
		//...init a resource...
	}
	
	public synchronized void shutdown() {
		if (!shutdown) {
			shutdown = true;
			reaper.interrupt();
		}
	}
	
	public synchronized Resource getResource(Object key) {
		if (shutdown) {
			throw new IllegalStateException();
		}
		Resource res = new ResourceImple(key);
		Reference<?> ref = new PhantomReference<Object>(key, queue);
		refs.put(ref, res);
		return res;
	}
	
	private static class ResourceImple implements Resource {
		int keyHash;
		boolean needsRelease = false;
		private WeakReference<Object> keyReference;//0402
		
		ResourceImple(Object key) {
			keyHash = System.identityHashCode(key);
//			0402変更----------------------------------------
			this.keyReference = new WeakReference<Object>(key);
//			ここまで-----------------------------------------
			// ...settings an extra resource...
			
			needsRelease = true;
		}
		
		public void use(Object key, Object... args) {
//			0402変更----------------------------------------
//			if (System.identityHashCode(key) != keyHash) {
//				throw new IllegalArgumentException("wrong key");
//			}
			//このkeyReferenceのgetがnullならば、本物のkeyはGCされているはずで、
			//引数のkeyは別のkeyである、と思う
			if (this.keyReference.get() != key) {
				throw new IllegalArgumentException("wrong key");
			}
//			ここまで-----------------------------------------
			//...use the resource...
			//リソースを使用している設定で、200msec待つ
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public synchronized void release() {
			if (needsRelease) {
				needsRelease = false;
				
				//...release the resource...
			}
		}
	}
	
	public class ReaperThread extends Thread {
		boolean sd = false;//0402
		public void run() {
			// do until interrupted
			while (true) {
				try {
					Reference<?> ref = queue.remove();
					Resource res = null;
					synchronized(ResourceManager.this) {
						res = refs.get(ref);
						refs.remove(ref);
						if (sd && refs.isEmpty()) {//0402追加
							break;
						}
					}
					res.release();
					ref.clear();
				} catch (InterruptedException ex) {
					sd = true;
					//break;//0402 comment out
				}

			}
		}
	}

}
