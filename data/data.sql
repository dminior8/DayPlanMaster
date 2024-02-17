-- Users
INSERT INTO Users (id, username, email, password, created_at) VALUES
(1, 'john_doe', 'john.doe@email.com', 'password123', '2024-02-11 08:30:00'),
(2, 'alice_smith', 'alice.smith@email.com', 'securepass', '2024-02-10 12:45:00'),
(3, 'bob_jones', 'bob.jones@email.com', 'pass123word', '2024-02-12 15:20:00');

-- Tasks
INSERT INTO Tasks (id, user_id, title, description, category, created_at, due_date, priority, isComplete) VALUES
(1, 1, 'Project Meeting', 'Discuss project updates and plan upcoming tasks', 'Meeting', '2024-02-11 10:00:00', '2024-02-15', 2, 0),
(2, 2, 'Write Report', 'Prepare a detailed report on the latest market trends', 'Work', '2024-02-10 13:30:00', '2024-02-14', 1, 1),
(3, 3, 'Task Assignment', 'Assign tasks to team members for the upcoming sprint', 'Planning', '2024-02-12 16:45:00', '2024-02-18', 3, 0);

-- Recurrence
INSERT INTO Recurrence (id, task_id, frequency, taskInterval, days) VALUES
(1, 1, 'Weekly', 1, 'Monday'),
(2, 2, 'Monthly', 2, 'Tuesday, Friday'),
(3, 3, 'Daily', 1, 'Weekdays');

-- Subtasks
INSERT INTO Subtasks (id, task_id, name, type, isComplete) VALUES
(1, 1, 'Research', 'Research', 0),
(2, 2, 'Introduction', 'Writing', 1),
(3, 3, 'Task List', 'Planning', 0);

-- Exercises
INSERT INTO Exercises (id, task_id, type, set_count, reps, isComplete) VALUES
(1, 1, 'Cardio', 3, 15, 0),
(2, 2, 'Strength Training', 4, 12, 1),
(3, 3, 'Yoga', 1, 10, 0);

-- Tasks_Exercises
INSERT INTO Tasks_Exercises (task_id, exercise_id) VALUES
(1, 1),
(2, 2),
(3, 3);

-- Tasks_Subtasks
INSERT INTO Tasks_Subtasks (task_id, subtask_id) VALUES
(1, 1),
(2, 2),
(3, 3);

-- Notification
INSERT INTO Notification (id, user_id, task_id, type, message, received_time) VALUES
(1, 1, 1, 'Reminder', 'Don''t forget the meeting at 10 AM', '2024-02-11 09:30:00'),
(2, 2, 2, 'Deadline', 'The report is due tomorrow. Ensure it is complete', '2024-02-13 16:00:00'),
(3, 3, 3, 'New Task', 'You have been assigned new tasks. Check your dashboard', '2024-02-12 17:30:00');

-- Achievement
INSERT INTO Achievement (id, user_id, name, description, received_date) VALUES
(1, 1, 'Productive Day', 'Completed all tasks for the day', '2024-02-11'),
(2, 2, 'Task Master', 'Completed 100 tasks', '2024-02-10'),
(3, 3, 'Early Bird', 'Completed a task before 9 AM', '2024-02-12');
