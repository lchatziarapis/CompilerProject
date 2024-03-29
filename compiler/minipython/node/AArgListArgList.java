/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class AArgListArgList extends PArgList
{
    private PExpression _expression_;
    private final LinkedList _comExpr_ = new TypedLinkedList(new ComExpr_Cast());

    public AArgListArgList()
    {
    }

    public AArgListArgList(
        PExpression _expression_,
        List _comExpr_)
    {
        setExpression(_expression_);

        {
            this._comExpr_.clear();
            this._comExpr_.addAll(_comExpr_);
        }

    }
    public Object clone()
    {
        return new AArgListArgList(
            (PExpression) cloneNode(_expression_),
            cloneList(_comExpr_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAArgListArgList(this);
    }

    public PExpression getExpression()
    {
        return _expression_;
    }

    public void setExpression(PExpression node)
    {
        if(_expression_ != null)
        {
            _expression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _expression_ = node;
    }

    public LinkedList getComExpr()
    {
        return _comExpr_;
    }

    public void setComExpr(List list)
    {
        _comExpr_.clear();
        _comExpr_.addAll(list);
    }

    public String toString()
    {
        return ""
            + toString(_expression_)
            + toString(_comExpr_);
    }

    void removeChild(Node child)
    {
        if(_expression_ == child)
        {
            _expression_ = null;
            return;
        }

        if(_comExpr_.remove(child))
        {
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

        for(ListIterator i = _comExpr_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set(newChild);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

    }

    private class ComExpr_Cast implements Cast
    {
        public Object cast(Object o)
        {
            PComExpr node = (PComExpr) o;

            if((node.parent() != null) &&
                (node.parent() != AArgListArgList.this))
            {
                node.parent().removeChild(node);
            }

            if((node.parent() == null) ||
                (node.parent() != AArgListArgList.this))
            {
                node.parent(AArgListArgList.this);
            }

            return node;
        }
    }
}
