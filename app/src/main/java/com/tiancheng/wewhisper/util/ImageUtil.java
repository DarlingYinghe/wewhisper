package com.tiancheng.wewhisper.util;

import com.bumptech.glide.request.RequestOptions;
import com.tiancheng.wewhisper.R;


/**
 * Created by 10919 on 2018/3/9/009.
 */

public class ImageUtil {

    public static RequestOptions getRequestOptions1() {
        RequestOptions requestOptions = new RequestOptions()
                .error(R.drawable.bg_more_light_glory)
                .placeholder(R.drawable.bg_more_light_glory);
        return requestOptions;
    }
}
