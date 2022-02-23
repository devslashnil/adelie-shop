package com.devslashnil.adelie.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_category")
public class Category extends BaseEntity {

    private String name;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

}
