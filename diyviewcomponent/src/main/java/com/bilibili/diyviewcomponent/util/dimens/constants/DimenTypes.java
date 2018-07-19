package com.bilibili.diyviewcomponent.util.dimens.constants;


public enum DimenTypes {

    //300,320,360,411，450

    //适配Android 3.2以上   大部分手机的sw值集中在  300-460之间
    DP_sw__300(300),  // values-sw300
    DP_sw__310(320),
    DP_sw__320(360),
    DP_sw__330(411),
    DP_sw__450(450),
    DP_sw__640(640),
    DP_sw__768(768);
    // 想生成多少自己以此类推


    /**
     * 屏幕最小宽度
     */
    private int swWidthDp;


    DimenTypes(int swWidthDp) {

        this.swWidthDp = swWidthDp;
    }

    public int getSwWidthDp() {
        return swWidthDp;
    }

    public void setSwWidthDp(int swWidthDp) {
        this.swWidthDp = swWidthDp;
    }

}
