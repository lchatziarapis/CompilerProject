/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class AFcStatement extends PStatement
{
    private final LinkedList _tab_ = new TypedLinkedList(new Tab_Cast());
    private PFunctionCall _functionCall_;

    public AFcStatement()
    {
    }

    public AFcStatement(
        List _tab_,
        PFunctionCall _functionCall_)
    {
        {
            this._tab_.clear();
            this._tab_.addAll(_tab_);
        }

        setFunctionCall(_functionCall_);

    }
    public Object clone()
    {
        return new AFcStatement(
            cloneList(_tab_),
            (PFunctionCall) cloneNode(_functionCall_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFcStatement(this);
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

    public PFunctionCall getFunctionCall()
    {
        return _functionCall_;
    }

    public void setFunctionCall(PFunctionCall node)
    {
        if(_functionCall_ != null)
        {
            _functionCall_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _functionCall_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_tab_)
            + toString(_functionCall_);
    }

    void removeChild(Node child)
    {
        if(_tab_.remove(child))
        {
            return;
        }

        if(_functionCall_ == child)
        {
            _functionCall_ = null;
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

        if(_functionCall_ == oldChild)
        {
            setFunctionCall((PFunctionCall) newChild);
            return;
        }

    }

    private class Tab_Cast implements Cast
    {
        public Object cast(Object o)
        {
            TTab node = (TTab) o;

            if((node.parent() != null) &&
                (node.parent() != AFcStatement.this))
            {
                node.parent().removeChild(node);
            }

            if((node.parent() == null) ||
                (node.parent() != AFcStatement.this))
            {
                node.parent(AFcStatement.this);
            }

            return node;
        }
    }
}
