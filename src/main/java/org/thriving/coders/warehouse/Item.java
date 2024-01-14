package org.thriving.coders.warehouse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {

    private Integer id;
    private String barcode;
    private String name;
    private String category;
}
