/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class ADivisionMultiplication extends PMultiplication
{
    private PMultiplication _multiplication_;
    private TDiv _div_;
    private PSomething _something_;

    public ADivisionMultiplication()
    {
    }

    public ADivisionMultiplication(
        PMultiplication _multiplication_,
        TDiv _div_,
        PSomething _something_)
    {
        setMultiplication(_multiplication_);

        setDiv(_div_);

        setSomething(_something_);

    }
    public Object clone()
    {
        return new ADivisionMultiplication(
            (PMultiplication) cloneNode(_multiplication_),
            (TDiv) cloneNode(_div_),
            (PSomething) cloneNode(_something_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADivisionMultiplication(this);
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

    public TDiv getDiv()
    {
        return _div_;
    }

    public void setDiv(TDiv node)
    {
        if(_div_ != null)
        {
            _div_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _div_ = node;
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
            + toString(_div_)
            + toString(_something_);
    }

    void removeChild(Node child)
    {
        if(_multiplication_ == child)
        {
            _multiplication_ = null;
            return;
        }

        if(_div_ == child)
        {
            _div_ = null;
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

        if(_div_ == oldChild)
        {
            setDiv((TDiv) newChild);
            return;
        }

        if(_something_ == oldChild)
        {
            setSomething((PSomething) newChild);
            return;
        }

    }
}