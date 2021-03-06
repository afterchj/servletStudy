package com.tpadsz.servlet.design.pattern.interpreter.mypackage;

import com.tpadsz.servlet.design.pattern.interpreter.Context;

/**
 * The interface of our BooleanExp Interpreter
 * BooleanExp definition is:
 * BooleanExp ::= VariableExp | Constant | OrExp | AndExp
 * | NotExp | '(' BooleanExp ')'
 * AndExp ::= BooleanExp 'and' BooleanExp
 * OrExp ::= BooleanExp 'or' BooleanExp
 * NotExp ::= BooleanExp 'not' BooleanExp
 * Constant ::= 'true' | 'false'
 * VariableExp ::= 'A' | 'B' | ... | 'Z'
 */

public interface BooleanExp {
    boolean Evaluate(Context c);

    BooleanExp Replace(String var, BooleanExp exp);

    BooleanExp Copy();
}