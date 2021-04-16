package cn.xeblog.action.handler.message;

import cn.xeblog.action.ConsoleAction;
import cn.xeblog.entity.Response;
import cn.xeblog.enums.Style;

/**
 * @author anlingyi
 * @date 2020/8/19
 */
public class SystemMessageHandler extends AbstractMessageHandler<String> {

    @Override
    public void handle(Response<String> response) {
        ConsoleAction.renderText(String.format("[%s] 系统消息：%s\n", response.getTime(), response.getBody()),
                Style.SYSTEM_MSG);
    }
}
