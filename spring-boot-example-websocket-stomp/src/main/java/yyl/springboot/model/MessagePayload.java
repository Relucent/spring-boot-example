package yyl.springboot.model;

/**
 * 消息承载对象
 */
public class MessagePayload {
    /** 消息主题 */
    private String topic;
    /** 消息内容 */
    private String message;
    /** 消息目标 */
    private String to;
    /** 消息来源 */
    private String from;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
