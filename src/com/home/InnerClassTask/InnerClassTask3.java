package com.home.InnerClassTask;

import java.util.List;
import java.util.Map;

public class InnerClassTask3 {
    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    private class TaskDataProvider implements DbDataProvider {
        @Override
        public void refreshAllData(Map criteria) {
            tasks = DbMock.getFakeTasks(ViewMock.getFakeTasksCriteria());
        }
    }

    private class NameDataProvider implements DbDataProvider {
        @Override
        public void refreshAllData(Map criteria) {
            names = DbMock.getFakeNames(ViewMock.getFakeNamesCriteria());
        }
    }

    public void refresh() {
        Map taskCriteria = ViewMock.getFakeTasksCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = ViewMock.getFakeNamesCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {
    }
}
