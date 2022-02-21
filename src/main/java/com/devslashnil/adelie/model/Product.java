package com.devslashnil.adelie.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
@Table(name = "product")
public class Product extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -8671870441470778243L;

    @NotEmpty(message = "Name of a product is required")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @NotEmpty(message = "Category of a product is required")
    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "params_id", referencedColumnName = "id")
    private ProductParams params;

    private int quantity;

    private String desc;

    private String weight;

    private String volume;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
