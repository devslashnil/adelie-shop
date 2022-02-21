package com.devslashnil.adelie.model;

import java.io.Serial;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee extends User implements Serializable {
    @Serial
    private static final long serialVersionUID = -7313799870610968213L;
}
