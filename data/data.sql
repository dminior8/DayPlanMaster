-- Dla tabeli users
INSERT INTO users (id, username, email, password) VALUES
(1, 'jan_kowalski', 'jan.kowalski@example.com', 'haslo123'),
(2, 'anna_nowak', 'anna.nowak@example.com', 'secret456'),
(3, 'tomasz_wisniewski', 'tomasz.wisniewski@example.com', 'secure789');

-- Dla tabeli tasks
INSERT INTO tasks (id, user_id, title, description, category, due_date, priority, is_complete, recurrence_id) VALUES
(1, 1, 'Przygotowanie raportu', 'Przygotować raport końcowy z wynikami projektu', 'Biznes', '2024-02-25', 1, 0, null),
(2, 2, 'Zakupy spożywcze', 'Zakupić produkty spożywcze na cały tydzień', 'Dom', '2024-02-20', 2, 0, null),
(3, 3, 'Trening na siłowni', 'Realizacja treningu siłowego według planu', 'Fitness', null, 3, 0, 1);

-- Dla tabeli recurrence
INSERT INTO recurrence (id, task_id, frequency, task_interval, days) VALUES
(1, 3, 'Tygodniowo', 1, 'poniedziałek, środa, piątek'),
(2, 3, 'Miesięcznie', 1, '1');

-- Dla tabeli subtasks
INSERT INTO subtasks (id, task_id, name, type, is_complete) VALUES
(1, 1, 'Przygotowanie danych', 'Przygotowanie danych do raportu', 0),
(2, 1, 'Analiza wyników', 'Analiza zebranych danych', 0),
(3, 2, 'Zakupy spożywcze', 'Zakupy spożywcze na obiad', 0);

-- Dla tabeli exercises
INSERT INTO exercises (id, task_id, type, set_count, reps, is_complete) VALUES
(1, 3, 'Podciąganie', 3, 10, 0),
(2, 3, 'Przysiady', 4, 15, 0);

-- Dla tabeli tasks_exercises
INSERT INTO tasks_exercises (task_id, exercise_id) VALUES
(3, 1),
(3, 2);

-- Dla tabeli tasks_subtasks
INSERT INTO tasks_subtasks (task_id, subtask_id) VALUES
(1, 1),
(1, 2),
(2, 3);

-- Dla tabeli notification
INSERT INTO notification (id, user_id, task_id, type, message, received_time) VALUES
(1, 1, 1, 'Przypomnienie', 'Raport do zrobienia', '2024-02-24 10:00:00'),
(2, 2, 2, 'Przypomnienie', 'Zakupy spożywcze', '2024-02-19 15:30:00');

-- Dla tabeli achievement
INSERT INTO achievement (id, user_id, name, description, received_date) VALUES
(1, 1, 'Master Productivity', 'Ukończ wszystkie zaplanowane zadania', '2024-03-01'),
(2, 2, 'Healthy Living', 'Zrealizuj 30 treningów w ciągu miesiąca', '2024-03-15');
