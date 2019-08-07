/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class AMultiplicationMultiplication extends PMultiplication
{
    private PMultiplication _multiplication_;
    private TMult _mult_;
    private PSomething _something_;

    public AMultiplicationMultiplication()
    {
    }

    public AMultiplicationMultiplication(
        PMultiplication _multiplication_,
        TMult _mult_,
        PSomething _something_)
    {
        setMultiplication(_multiplication_);

        setMult(_mult_);

        setSomething(_something_);

    }
    public Object clone()
    {
        return new AMultiplicationMultiplication(
            (PMultiplication) cloneNode(_multiplication_),
            (TMult) cloneNode(_mult_),
            (PSomething) cloneNode(_something_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMultiplicationMultiplication(this);
    }

    public PMultiplication getMultiplication()
    {
        return _multiplication_;
    }

    public void setMultiplication(PMultiplication node)
    {
        if(_multiplication_ != null)
        {
            _multiplication_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _multiplication_ = node;
    }

    public TMult getMult()
    {
        return _mult_;
    }

    public void setMult(TMult node)
    {
        if(_mult_ != null)
        {
            _mult_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _mult_ = node;
    }

    public PSomething getSomething()
    {
        return _something_;
    }

    public void setSomething(PSomething node)
    {
        if(_something_ != null)
        {
            _something_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _something_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_multiplication_)
            + toString(_mult_)
            + toString(_something_);
    }

    void removeChild(Node child)
    {
        if(_multiplication_ == child)
        {
            _multiplication_ = null;
            return;
        }

        if(_mult_ == child)
        {
            _mult_ = null;
            return;
        }

        if(_something_ == child)
        {
            _something_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_multiplication_ == oldChild)
        {
            setMultiplication((PMultiplication) newChild);
            return;
        }

        if(_mult_ == oldChild)
        {
            setMult((TMult) newChild);
            return;
        }

        if(_something_ == oldChild)
        {
            setSomething((PSomething) newChild);
            return;
        }

    }
}
