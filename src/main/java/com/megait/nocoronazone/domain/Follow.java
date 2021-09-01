package com.megait.nocoronazone.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class Follow {
    @Id @GeneratedValue
    private Long no;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Member who;

    @ManyToMany
    private List<Member> whom;

    @Builder
    public Follow(){
        whom = new ArrayList<>();
    }

    public void addFollowMember(Member member){
        this.whom.add(member);
    }

    public void removeFollowMember(int index){

        this.whom.remove(index);

    }

}
