package com.home.InnerClassTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DbMock {
    private static final List<InnerClassTask3.Task> FAKE_TASKS = new ArrayList<>();
    private static final List<String> FAKE_NAMES = new ArrayList<>();

    public static List<InnerClassTask3.Task> getFakeTasks(Map criteria) {
        return ViewMock.getFakeTasksCriteria().equals(criteria) ? FAKE_TASKS : null;
    }

    public static List<String> getFakeNames(Map criteria) {
        return ViewMock.getFakeNamesCriteria().equals(criteria) ? FAKE_NAMES : null;
    }
}
