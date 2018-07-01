/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.shampooo0o.sfx;

import java.util.ArrayList;
import java.util.List;

public final class DemoList {
    public static final String DEMO_CATEGORY[] = {
            "Google Assistant",
            "Adjustments",
    };

    private static List<Demo> list;
    private static long count = 0;

    public static List<Demo> getList() {
        if (list == null) {
            list = setupDemo();
        }
        return list;
    }

    public static List<Demo> setupDemo() {
        list = new ArrayList<>();
        String title[] = {
                "Start Demo",
        };

        String description = "Google Assistant fake demo for offline environment. ";
        String studio[] = {
                "by Yusuke Watanabe"
        };

        for (int index = 0; index < title.length; ++index) {
            list.add(
                    buildMovieInfo(
                            title[index],
                            description,
                            studio[index]));
        }

        return list;
    }

    private static Demo buildMovieInfo(
            String title,
            String description,
            String studio) {
        Demo demo = new Demo();
        demo.setId(count++);
        demo.setTitle(title);
        demo.setDescription(description);
        demo.setStudio(studio);
        return demo;
    }
}
