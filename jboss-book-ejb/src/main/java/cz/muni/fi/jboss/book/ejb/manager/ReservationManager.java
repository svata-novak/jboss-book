package cz.muni.fi.jboss.book.ejb.manager;

import java.util.List;

import cz.muni.fi.jboss.book.persistence.ReservationState;
import cz.muni.fi.jboss.book.persistence.entity.BookCopy;
import cz.muni.fi.jboss.book.persistence.entity.BookCopyReservation;
import cz.muni.fi.jboss.book.persistence.entity.User;

public interface ReservationManager {

	/**
	 * Used by Reader for book reservations
	 */
	public BookCopyReservation reserveBook(BookCopy bookCopy, User reader);

	/**
	 * Used by Librarian when the reserved book is prepared
	 */
	public void prepareBook(BookCopyReservation reservation);

	/**
	 * Used by Librarian when he's lending the book (or BookCopy to be precise)
	 */
	public void lendBook(BookCopyReservation reservation);

	/**
	 * Used by Librarian when the Reader returns the book (BookCopy)
	 */
	public void returnBook(BookCopyReservation reservation);

	/**
	 * Returns all BookCopyReservations with the specified state
	 * 
	 * @param reader
	 *            Limits the returned reservations to those with the specific
	 *            Reader. If null, no such filtering is done.
	 */
	public List<BookCopyReservation> getBookCopyReservations(User reader, ReservationState state);

}
