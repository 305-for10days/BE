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
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
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

    @Column(name = "setCount")
    private Integer setCount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "routineId", nullable = true)
    private UserRoutine routine;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exerciseId")
    private Exercise exercise;

    public void setRoutine(UserRoutine routine) {
        this.routine = routine;

        if (!routine.getRoutineItems().contains(this)) {
            routine.getRoutineItems().add(this);
        }
    }

}
