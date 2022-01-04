package com.project.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.cfg.ConfigurationProvider;
import com.project.entity.Note;
import com.project.entity.User;

public class NoteDao {

	/**
	 * Store notes data.
	 */
	public int saveNote(Note note) {
		int status =0;
		try {
			SessionFactory factory = ConfigurationProvider.getSessionFactory();
			Session session  = factory.openSession();
			Transaction transaction = session.beginTransaction();
			status = (int)session.save(note);
			
			transaction.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception in NoteDao.saveNote(Note note)");
			e.printStackTrace();
		}
		return status;
	}
	
	/**
	 * Get all Notes in database.
	 */
	@SuppressWarnings("unchecked")
	public List<Note> getNotes(String email){
		List<Note> list = null;
		try {
			SessionFactory factory = ConfigurationProvider.getSessionFactory();
			Session session = factory.openSession();
			TypedQuery<Note> query = session.createQuery("FROM Note where email=:e");
			query.setParameter("e", email);
			list = query.getResultList();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception in NoteDao.getNotes()");
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Delete Note with id.
	 */
	public int deleteNote(int noteid) {
		int status =0;
		System.out.println("Inside of NoteDao");
		try {
			SessionFactory factory = ConfigurationProvider.getSessionFactory();
			Session session  = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Note note = new Note();
			note.setId(noteid);
			session.delete(note);
			status = 1;
			transaction.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception in NoteDao.deleteNote(int noteid)");
			e.printStackTrace();
		}
		return status;
	}
	
	
	/**
	 * Get Notes with id.
	 */
	public Note getNotesWithId(int noteid){
		Note note= null;
		try {
			SessionFactory factory = ConfigurationProvider.getSessionFactory();
			Session session = factory.openSession();
			note = session.get(Note.class, noteid);
			session.close();
		} catch (Exception e) {
			System.out.println("Exception in NoteDao.getNotes()");
			e.printStackTrace();
		}
		return note;
	}
	
	/**
	 * Search note with id.
	 */
	public Note searchNotesWithId(int noteid){
		Note note= null;
		try {
			SessionFactory factory = ConfigurationProvider.getSessionFactory();
			Session session = factory.openSession();
			note = session.get(Note.class, noteid);
			session.close();
		} catch (Exception e) {
			System.out.println("Exception in NoteDao.getNotes()");
			e.printStackTrace();
		}
		return note;
	}
	
	
	/**
	 * Update Notes with id.
	 */
	@SuppressWarnings("unchecked")
	public int updateNoteWithId(int id, String title, String content){
		int status =0;
		try {
			SessionFactory factory = ConfigurationProvider.getSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			TypedQuery<Note> query = session.createQuery("Update Note set title=:newtitle, content=:newcontent where id=:noteid");
			query.setParameter("noteid", id);
			query.setParameter("newtitle", title);
			query.setParameter("newcontent", content);
			status = query.executeUpdate();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception in NoteDao.getNotes()");
			e.printStackTrace();
		}
		return status;
	}
	
	/**
	 * Save User.
	 */
	public int saveUser(User user) {
		int status = 0;
		try {
			SessionFactory factory = ConfigurationProvider.getSessionFactory();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			status = (int)session.save(user);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception in NoteDao.saveUser(User user)");
			e.printStackTrace();
		}
		return status;
	}
	
	/**
	 * Get User data;
	 */
	@SuppressWarnings("unchecked")
	public User getUser(String email) {
		User user = null;
		List<User> list = null;
		System.out.printf("NoteDao : "+email);
		try {
			SessionFactory factory = ConfigurationProvider.getSessionFactory();
			Session session = factory.openSession();
			TypedQuery<User> query = session.createQuery("FROM User u where u.email=:e ");
			query.setParameter("e",email);
			//query.setParameter("p",password);
			list = query.getResultList();
			user = list.get(0);
			session.close();
		} catch (Exception e) {
			System.out.println("Exception in NoteDao.saveUser(User user)");
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * Check Uese already registred.
	 */
	@SuppressWarnings("unchecked")
	public User checkUser(String email) {
		User user = null;
		List<User> list = null;
		try {
			SessionFactory factory = ConfigurationProvider.getSessionFactory();
			Session session = factory.openSession();
			TypedQuery<User> query = session.createQuery("FROM User u where u.email=:e ");
			query.setParameter("e",email);
			list = query.getResultList();
			user = list.get(0);
			session.close();
		} catch (Exception e) {
			System.out.println("Exception in NoteDao.saveUser(User user)");
			e.printStackTrace();
		}
		return user;
	}
	
	/*public static void main(String args[]) {
		NoteDao note = new NoteDao();
		List<Note> list = note.getNotes();
		for(Note n : list) {
			System.out.println(n.getContent());
		}
		
	}*/
}
