/**
 * @author: maxu1
 * @date: 2019/2/1 10:49
 */

package com.mxin.mxinstart;

import com.mxin.mxinstart.netty.WSServer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author maxu
 */
@Component
public class NettyBooter implements ApplicationListener<ContextRefreshedEvent> {
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		if (contextRefreshedEvent.getApplicationContext().getParent() == null) {
			WSServer.getInstance().start();
		}
	}
}
