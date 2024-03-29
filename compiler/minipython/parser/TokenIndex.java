/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.parser;

import minipython.node.*;
import minipython.analysis.*;

class TokenIndex extends AnalysisAdapter
{
    int index;

    public void caseTTab(TTab node)
    {
        index = 0;
    }

    public void caseTPlus(TPlus node)
    {
        index = 1;
    }

    public void caseTMinus(TMinus node)
    {
        index = 2;
    }

    public void caseTMult(TMult node)
    {
        index = 3;
    }

    public void caseTDiv(TDiv node)
    {
        index = 4;
    }

    public void caseTEq(TEq node)
    {
        index = 5;
    }

    public void caseTDeq(TDeq node)
    {
        index = 6;
    }

    public void caseTMinusEq(TMinusEq node)
    {
        index = 7;
    }

    public void caseTDivEq(TDivEq node)
    {
        index = 8;
    }

    public void caseTNotEqual(TNotEqual node)
    {
        index = 9;
    }

    public void caseTDef(TDef node)
    {
        index = 10;
    }

    public void caseTLPar(TLPar node)
    {
        index = 11;
    }

    public void caseTRPar(TRPar node)
    {
        index = 12;
    }

    public void caseTLBr(TLBr node)
    {
        index = 13;
    }

    public void caseTRBr(TRBr node)
    {
        index = 14;
    }

    public void caseTIf(TIf node)
    {
        index = 15;
    }

    public void caseTWhile(TWhile node)
    {
        index = 16;
    }

    public void caseTFor(TFor node)
    {
        index = 17;
    }

    public void caseTPrint(TPrint node)
    {
        index = 18;
    }

    public void caseTReturn(TReturn node)
    {
        index = 19;
    }

    public void caseTComma(TComma node)
    {
        index = 20;
    }

    public void caseTIn(TIn node)
    {
        index = 21;
    }

    public void caseTLess(TLess node)
    {
        index = 22;
    }

    public void caseTGreat(TGreat node)
    {
        index = 23;
    }

    public void caseTTrue(TTrue node)
    {
        index = 24;
    }

    public void caseTSemi(TSemi node)
    {
        index = 25;
    }

    public void caseTFalse(TFalse node)
    {
        index = 26;
    }

    public void caseTQuote(TQuote node)
    {
        index = 27;
    }

    public void caseTSquote(TSquote node)
    {
        index = 28;
    }

    public void caseTNumber(TNumber node)
    {
        index = 29;
    }

    public void caseTIdentifier(TIdentifier node)
    {
        index = 30;
    }

    public void caseTString1(TString1 node)
    {
        index = 31;
    }

    public void caseTString2(TString2 node)
    {
        index = 32;
    }

    public void caseEOF(EOF node)
    {
        index = 33;
    }
}
