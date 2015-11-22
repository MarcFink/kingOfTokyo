package KingOfTokyoMessage;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Message {
	private static long messageID = 0;

	public Message(@Element(name = "type") MessageType type) {
		this.type = type;
		this.id = nextMessageID();
		this.timestamp = System.currentTimeMillis();
	}

	public enum MessageType {
		Attack, Heal, WinGame, InTokyo, Dead, LoseLifePoint, getGloryPoint, EndOfTurn
	};

	@Attribute
	private long id;

	@Attribute
	private long timestamp;

	@Element
	private MessageType type;

	@Element
	private String name;

	@Element
	private String content;

	private static long nextMessageID() {
		return messageID++;
	}
}
