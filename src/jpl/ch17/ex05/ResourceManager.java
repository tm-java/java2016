package jpl.ch17.ex05;

/**
 * リソースマネージャーが持つセマンティクス
 * getResouceとshitdownが呼ばれた時に、到達不可能なリソースの解放を行う。
 * shutdownが呼ばれてもなお、すべてのリソースが解放されていな時は、IllegalStateExceptionがスローされる
 */
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
	boolean shutdown = false;

	public ResourceManager() {
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>, Resource>();
		// ...init a resource...
	}

	public synchronized void shutdown() {
		if (!shutdown) {
			// 到達不可能なリソースの解放
			//0512本来はここで、全部解放されるまで待つ
			this.releaseResource();
			
			if (refs.isEmpty()) {			
				shutdown = true;
				return;
			}
			throw new IllegalStateException();
		}
	}

	public synchronized Resource getResource(Object key) {
		if (shutdown) {
			throw new IllegalStateException();
		}
		// 到達不可能なリソースの解放
		this.releaseResource();

		// リソースの作成
		Resource res = new ResourceImple(key);
		Reference<?> ref = new PhantomReference<Object>(key, queue);
		refs.put(ref, res);
		return res;
	}

	public synchronized void releaseResource() {
		// 到達不可能なリソースの解放
		Reference<?> ref;
		Resource res = null;
		while ((ref = queue.poll()) != null) {
			res = refs.get(ref);
			refs.remove(ref);
			res.release();
			ref.clear();
			res = null;
		}
	}

	private static class ResourceImple implements Resource {
		int keyHash;
		boolean needsRelease = false;
		private WeakReference<Object> keyReference;// 0402

		ResourceImple(Object key) {
			keyHash = System.identityHashCode(key);
			// 0402変更----------------------------------------
			this.keyReference = new WeakReference<Object>(key);
			// ここまで-----------------------------------------
			// ...settings an extra resource...

			needsRelease = true;
		}

		public void use(Object key, Object... args) {
			// 0402変更----------------------------------------
			// if (System.identityHashCode(key) != keyHash) {
			// throw new IllegalArgumentException("wrong key");
			// }
			// このkeyReferenceのgetがnullならば、本物のkeyはGCされているはずで、
			// 引数のkeyは別のkeyである、と思う
			if (this.keyReference.get() != key) {
				throw new IllegalArgumentException("wrong key");
			}
			// ここまで-----------------------------------------
			// ...use the resource...
			// リソースを使用している設定で、200msec待つ
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public synchronized void release() {
			if (needsRelease) {
				needsRelease = false;

				// ...release the resource...
			}
		}
	}

}
