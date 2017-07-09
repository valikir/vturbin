package ru.job4j.Encapsulation;

/**
* item class.
*
* @author Valentin Turbin
* @version 1
* @since 07.07.2017
*/

public class Item {
	/**
	 * @param id номер заявки
	 */
	private String id;
	/**
	 * @param name имя заявки
	 */
	private String name;
	/**
	 * @param desc описание заявки
	 */
	private String desc;
	/**
	 * @param created время в милисекундах создания
	 */
	private long created;
	/**
	 * @param comments массив комментариев
	 */
	private String[] comments;

	public Item(String id, String name, String desc, long created, String[] comments) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.created = created;
		this.comments = comments;
	}

	public String getId() {
	    return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getDesc() {
        return this.desc;
    }
    public long getCreated() {
        return this.created;
    }
    public String[] getComments() {
        return this.comments;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setCreated(long created) {
        this.created = created;
    }
    public void setComments(String[] comments) {
        this.comments = comments;
    }

}