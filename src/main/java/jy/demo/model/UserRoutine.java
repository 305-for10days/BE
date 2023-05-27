package jy.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@NoArgsConstructor
public class UserRoutine extends Datetime implements Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exerciseGoalId")
    private ExerciseGoal exerciseGoal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "routine", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RoutineItem> routineItems;

    @Column(name = "calorie")
    private Integer calorie;

    @Column(name = "isDefault")
    private Boolean isDefault;

    public void addRoutineItem(RoutineItem routineItem) {
        if (Objects.isNull(this.routineItems)) {
            this.routineItems = new ArrayList<>();
        }

        this.routineItems.add(routineItem);

        if (!Objects.equals(routineItem.getRoutine(), this)) {
            routineItem.setRoutine(this);
        }
    }

    public UserRoutine(Long id) {
        this.id = id;
    }
}
