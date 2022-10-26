package miniProject.accountBook.repository;

import miniProject.accountBook.domain.Comment;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Comment> findComment(Long commentId) {
        Comment comment = em.find(Comment.class, commentId);
        return Optional.ofNullable(comment);
    }

    @Override
    public Comment deleteComment(Comment comment) {
        em.remove(comment);
        return comment;
    }
}
