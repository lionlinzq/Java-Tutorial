
package com.lzq.demo.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReleaseRule implements Comparable<ReleaseRule>{

    private Integer dimension;
    private List<String> rangeList;



    @Override
    public int compareTo(@NotNull ReleaseRule o) {
        return this.dimension - o.getDimension();
    }
}
