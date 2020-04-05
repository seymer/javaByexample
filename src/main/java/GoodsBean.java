import lombok.Data;

import java.io.Serializable;

/**
 * @author Seymer
 */
@Data
public class GoodsBean implements Serializable {

    private Integer goodsId;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}
