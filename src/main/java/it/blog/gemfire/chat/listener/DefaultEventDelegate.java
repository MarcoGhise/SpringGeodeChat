package it.blog.gemfire.chat.listener;

import org.apache.geode.cache.Operation;
import org.apache.geode.cache.query.CqEvent;
import org.apache.geode.cache.query.CqQuery;

public class DefaultEventDelegate implements EventDelegate {

	@Override
	public void handleEvent(CqEvent event) {}

	@Override
	public void handleEvent(Operation baseOp) {}

	@Override
	public void handleEvent(Object key) {}

	@Override
	public void handleEvent(Object key, Object newValue) {
		if (newValue != null)
			System.out.println(newValue);
		else
			System.out.println(String.format("Expires key %s", key));
	}

	@Override
	public void handleEvent(Throwable throwable) {}

	@Override
	public void handleQuery(CqQuery cq) {}

	@Override
	public void handleEvent(CqEvent event, Operation baseOp, byte[] deltaValue) {}

	@Override
	public void handleEvent(CqEvent event, Operation baseOp, Operation queryOp, Object key, Object newValue) {}

}
