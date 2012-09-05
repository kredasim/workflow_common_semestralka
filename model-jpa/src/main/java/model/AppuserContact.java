package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the appuser_contact database table.
 * 
 */
@Entity
@Table(name="appuser_contact")
public class AppUserContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_contactid")
	private Integer userContactid;

	//bi-directional many-to-one association to Appuser
	@ManyToOne
	@JoinColumn(name="appuserid")
	private AppUser appUser;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="contactid")
	private Contact contact;

	public AppUserContact() {
	}

	public Integer getUserContactid() {
		return this.userContactid;
	}

	public void setUserContactid(Integer userContactid) {
		this.userContactid = userContactid;
	}

	public AppUser getAppuser() {
		return this.appUser;
	}

	public void setAppuser(AppUser appUser) {
		this.appUser = appUser;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}