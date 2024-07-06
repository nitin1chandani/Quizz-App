INSERT INTO "quizz-question-db".question_schema.questions (
    id, category, difficulty_lvl, question_ttl, right_ans, opt_1, opt_2, opt_3, opt_4
) VALUES
    (1, 'Python', 'Easy', 'What is the output of print(2 ** 3) in Python?', '8', '6', '8', '9', '12'),
    (2, 'Java', 'Medium', 'Which of the following is a correct syntax to output "Hello World" in Java?', 'System.out.println("Hello World");', 'print("Hello World");', 'Console.WriteLine("Hello World");', 'echo "Hello World";', 'System.out.println("Hello World");'),
    (3, 'Java', 'Hard', 'In Java, which keyword is used to define a class method that cannot be overridden in a subclass?', 'final', 'static', 'abstract', 'final', 'private'),
    (4, 'General', 'Easy', 'Which of the following languages is not a programming language?', 'HTML', 'Python', 'Java', 'HTML', 'C++'),
    (5, 'General', 'Medium', 'What is the time complexity of accessing an element in a hash table?', 'O(1)', 'O(1)', 'O(n)', 'O(log n)', 'O(n log n)'),
    (6, 'Python', 'Hard', 'Which function is used to read a string from standard input in Python 3?', 'input()', 'raw_input()', 'scanf()', 'input()', 'gets()');
