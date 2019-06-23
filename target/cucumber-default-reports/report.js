$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/AddEmployees.feature");
formatter.feature({
  "name": "Add Employee",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@addEmplyee"
    },
    {
      "name": "@sprint5"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I logged in into OrangeHrm",
  "keyword": "Given "
});
formatter.match({
  "location": "AddEmployeeSteps.i_logged_in_into_OrangeHrm()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on PIM link",
  "keyword": "And "
});
formatter.match({
  "location": "AddEmployeeSteps.i_click_on_PIM_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on AddEmployee link",
  "keyword": "And "
});
formatter.match({
  "location": "AddEmployeeSteps.i_click_on_AddEmployee_link()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add Employee Labels Verification",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@addEmplyee"
    },
    {
      "name": "@sprint5"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@temp"
    }
  ]
});
formatter.step({
  "name": "I see following labels",
  "rows": [
    {
      "cells": [
        "First Namessss"
      ]
    },
    {
      "cells": [
        "Middle Name"
      ]
    },
    {
      "cells": [
        "Last Name"
      ]
    },
    {
      "cells": [
        "Employee Id"
      ]
    },
    {
      "cells": [
        "Location"
      ]
    },
    {
      "cells": [
        "Create Login Details"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "AddEmployeeSteps.i_see_following_labels(DataTable)"
});
formatter.result({
  "error_message": "java.lang.AssertionError\n\tat org.junit.Assert.fail(Assert.java:86)\n\tat org.junit.Assert.assertTrue(Assert.java:41)\n\tat org.junit.Assert.assertTrue(Assert.java:52)\n\tat com.orangehrm.steps.AddEmployeeSteps.i_see_following_labels(AddEmployeeSteps.java:118)\n\tat ✽.I see following labels(file:src/test/resources/features/AddEmployees.feature:36)\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "status": "passed"
});
});