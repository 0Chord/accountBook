package miniProject.accountBook.service;

import miniProject.accountBook.domain.Comment;
import miniProject.accountBook.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentService {

    CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public String store(Comment comment) {
        commentRepository.saveComment(comment);
        return comment.getNickname();
    }

    public List<Comment> findCommentsByBoardId(Long id) {
        return commentRepository.findCommentsBoardId(id);
    }
}
