/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class ACalculateStatement extends PStatement
{
    private final LinkedList _tab_ = new TypedLinkedList(new Tab_Cast());
    private TIdentifier _identifier_;
    private PEvaluator _evaluator_;
    private PExpression _expression_;

    public ACalculateStatement()
    {
    }

    public ACalculateStatement(
        List _tab_,
        TIdentifier _identifier_,
        PEvaluator _evaluator_,
        PExpression _expression_)
    {
        {
            this._tab_.clear();
            this._tab_.addAll(_tab_);
        }

        setIdentifier(_identifier_);

        setEvaluator(_evaluator_);

        setExpression(_expression_);

    }
    public Object clone()
    {
        return new ACalculateStatement(
            cloneList(_tab_),
            (TIdentifier) cloneNode(_identifier_),
            (PEvaluator) cloneNode(_evaluator_),
            (PExpression) cloneNode(_expression_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACalculateStatement(this);
    }

    public LinkedList getTab()
    {
        return _tab_;
    }

    public void setTab(List list)
    {
        _tab_.clear();
        _tab_.addAll(list);
    }

    public TIdentifier getIdentifier()
    {
        return _identifier_;
    }

    public void setIdentifier(TIdentifier node)
    {
        if(_identifier_ != null)
        {
            _identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _identifier_ = node;
    }

    public PEvaluator getEvaluator()
    {
        return _evaluator_;
    }

    public void setEvaluator(PEvaluator node)
    {
        if(_evaluator_ != null)
        {
            _evaluator_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _evaluator_ = node;
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

    public String toString()
    {
        return ""
            + toString(_tab_)
            + toString(_identifier_)
            + toString(_evaluator_)
            + toString(_expression_);
    }

    void removeChild(Node child)
    {
        if(_tab_.remove(child))
        {
            return;
        }

        if(_identifier_ == child)
        {
            _identifier_ = null;
            return;
        }

        if(_evaluator_ == child)
        {
            _evaluator_ = null;
            return;
        }

        if(_expression_ == child)
        {
            _expression_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        for(ListIterator i = _tab_.listIterator(); i.hasNext();)
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

        if(_identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        if(_evaluator_ == oldChild)
        {
            setEvaluator((PEvaluator) newChild);
            return;
        }

        if(_expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

    }

    private class Tab_Cast implements Cast
    {
        public Object cast(Object o)
        {
            TTab node = (TTab) o;

            if((node.parent() != null) &&
                (node.parent() != ACalculateStatement.this))
            {
                node.parent().removeChild(node);
            }

            if((node.parent() == null) ||
                (node.parent() != ACalculateStatement.this))
            {
                node.parent(ACalculateStatement.this);
            }

            return node;
        }
    }
}
