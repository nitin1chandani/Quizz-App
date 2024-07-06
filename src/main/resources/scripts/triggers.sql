CREATE OR REPLACE FUNCTION question_schema.question_history_function()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO question_log_schema.question_history (
        question_id, category, difficulty_lvl, question_ttl, right_ans, opt_1, opt_2, opt_3, opt_4, action_type, action_tmst
    )
    VALUES (
        NEW.id, NEW.category, NEW.difficulty_lvl, NEW.question_ttl, NEW.right_ans, NEW.opt_1, NEW.opt_2, NEW.opt_3, NEW.opt_4, TG_OP, NOW()
    );
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER question_history_trigger
AFTER INSERT OR UPDATE ON question_schema.questions
FOR EACH ROW EXECUTE FUNCTION question_schema.question_history_function();