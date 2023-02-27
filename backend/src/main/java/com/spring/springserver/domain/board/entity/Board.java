package com.spring.springserver.domain.board.entity;

import com.spring.springserver.domain.category.entity.Category;
import com.spring.springserver.domain.like.entity.Recommend;
import com.spring.springserver.domain.reply.entity.Reply;
import com.spring.springserver.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

// https://velog.io/@deannn/Spring-Boot-Blog-Project-DB-%ED%85%8C%EC%9D%B4%EB%B8%94-%EB%A7%8C%EB%93%A4%EA%B8%B0

@Getter
@NoArgsConstructor
@DynamicInsert
@Entity
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String title;

    @Lob
    private String content; // @Lob - 대용량 데이터를 처리하기 위한 어노테이션.

    @Setter
    @ColumnDefault("0")
    private int view;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Reply> reply;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    private List<Recommend> recommends;

    @Transient // 게시글을 클릭했을 때, 해당 유저가 좋아요를 눌렀는지 여부
    private boolean likeState;

    @Transient // 좋아요 갯수
    private int likeCount;

    @CreationTimestamp
    private Timestamp createData;

    @Builder
    public Board(String title, String content, Member member, Category category){
        this.title = title;
        this.content = content;
        this.member = member;
        this.category = category;
    }
}
