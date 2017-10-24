package com.collect.model;

import java.util.List;

/**
 * Created by zhangyuncai on 2017/9/20.
 */

public class Test4Model {


    private List<AreaBean> area;
    private List<CatBean> cat;

    public List<AreaBean> getArea() {
        return area;
    }

    public void setArea(List<AreaBean> area) {
        this.area = area;
    }

    public List<CatBean> getCat() {
        return cat;
    }

    public void setCat(List<CatBean> cat) {
        this.cat = cat;
    }

    public static class AreaBean {
        /**
         * codeId : 5
         * codeVal : AREA001
         * codeDesc : 绍兴钱清
         * seqNum : 1
         */

        private int codeId;
        private String codeVal;
        private String codeDesc;
        private int seqNum;

        public int getCodeId() {
            return codeId;
        }

        public void setCodeId(int codeId) {
            this.codeId = codeId;
        }

        public String getCodeVal() {
            return codeVal;
        }

        public void setCodeVal(String codeVal) {
            this.codeVal = codeVal;
        }

        public String getCodeDesc() {
            return codeDesc;
        }

        public void setCodeDesc(String codeDesc) {
            this.codeDesc = codeDesc;
        }

        public int getSeqNum() {
            return seqNum;
        }

        public void setSeqNum(int seqNum) {
            this.seqNum = seqNum;
        }
    }

    public static class CatBean {
        /**
         * catCode : 1
         * catName : 人棉纱
         * sku : [{"skuCode":"SKU001","skuName":"普梳"}]
         */

        private String catCode;
        private String catName;
        private List<SkuBean> sku;

        public String getCatCode() {
            return catCode;
        }

        public void setCatCode(String catCode) {
            this.catCode = catCode;
        }

        public String getCatName() {
            return catName;
        }

        public void setCatName(String catName) {
            this.catName = catName;
        }

        public List<SkuBean> getSku() {
            return sku;
        }

        public void setSku(List<SkuBean> sku) {
            this.sku = sku;
        }

        public static class SkuBean {
            /**
             * skuCode : SKU001
             * skuName : 普梳
             */

            private String skuCode;
            private String skuName;

            public String getSkuCode() {
                return skuCode;
            }

            public void setSkuCode(String skuCode) {
                this.skuCode = skuCode;
            }

            public String getSkuName() {
                return skuName;
            }

            public void setSkuName(String skuName) {
                this.skuName = skuName;
            }
        }
    }
}
