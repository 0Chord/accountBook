package miniProject.accountBook.repository;

import miniProject.accountBook.domain.Comment;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaCommentRepository implements CommentRepository{

    EntityManager em;

    public JpaCommentRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Comment saveComment(Comment comment) {
        em.persist(comment);
        return comment;
    }

    @Override
    public List<Comment> findCommentsBoardId(Long id) {
        List<Comment> result = em.createQuery("select c from Comment c where c.board.orderId = :id", Comment.class)
                .setParameter("id", id)
                .getResultList();
        return result;
    }
}
