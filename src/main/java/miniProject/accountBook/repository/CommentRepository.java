package miniProject.accountBook.repository;

import miniProject.accountBook.domain.Comment;

import java.util.List;

public interface CommentRepository {
    Comment saveComment(Comment comment);
    List<Comment> findCommentsBoardId(Long id);
}
