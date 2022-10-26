package miniProject.accountBook.repository;

import miniProject.accountBook.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    Comment saveComment(Comment comment);
    List<Comment> findCommentsBoardId(Long id);
    Optional<Comment> findComment(Long commentId);
    Comment deleteComment(Comment comment);
}
