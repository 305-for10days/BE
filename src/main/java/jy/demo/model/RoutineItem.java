package jy.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@Builder
@DynamicUpdate
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoutineItem extends Datetime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "goalCalorie")
    private Integer goalCalorie;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "routineId")
    private Routine routine;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dRoutineId")
    private DefaultRoutine defaultRoutine;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exerciseId")
    private Exercise exercise;
}
