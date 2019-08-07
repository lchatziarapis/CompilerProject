/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class ACalculate2Statement extends PStatement
{
    private final LinkedList _tab_ = new TypedLinkedList(new Tab_Cast());
    private TIdentifier _identifier_;
    private TLBr _lBr_;
    private PExpression _leftExpr_;
    private TRBr _rBr_;
    private TEq _eq_;
    private PExpression _rightExpr_;

    public ACalculate2Statement()
    {
    }

    public ACalculate2Statement(
        List _tab_,
        TIdentifier _identifier_,
        TLBr _lBr_,
        PExpression _leftExpr_,
        TRBr _rBr_,
        TEq _eq_,
        PExpression _rightExpr_)
    {
        {
            this._tab_.clear();
            this._tab_.addAll(_tab_);
        }

        setIdentifier(_identifier_);

        setLBr(_lBr_);

        setLeftExpr(_leftExpr_);

        setRBr(_rBr_);

        setEq(_eq_);

        setRightExpr(_rightExpr_);

    }
    public Object clone()
    {
        return new ACalculate2Statement(
            cloneList(_tab_),
            (TIdentifier) cloneNode(_identifier_),
            (TLBr) cloneNode(_lBr_),
            (PExpression) cloneNode(_leftExpr_),
            (TRBr) cloneNode(_rBr_),
            (TEq) cloneNode(_eq_),
            (PExpression) cloneNode(_rightExpr_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACalculate2Statement(this);
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

    public TLBr getLBr()
    {
        return _lBr_;
    }

    public void setLBr(TLBr node)
    {
        if(_lBr_ != null)
        {
            _lBr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _lBr_ = node;
    }

    public PExpression getLeftExpr()
    {
        return _leftExpr_;
    }

    public void setLeftExpr(PExpression node)
    {
        if(_leftExpr_ != null)
        {
            _leftExpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _leftExpr_ = node;
    }

    public TRBr getRBr()
    {
        return _rBr_;
    }

    public void setRBr(TRBr node)
    {
        if(_rBr_ != null)
        {
            _rBr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _rBr_ = node;
    }

    public TEq getEq()
    {
        return _eq_;
    }

    public void setEq(TEq node)
    {
        if(_eq_ != null)
        {
            _eq_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _eq_ = node;
    }

    public PExpression getRightExpr()
    {
        return _rightExpr_;
    }

    public void setRightExpr(PExpression node)
    {
        if(_rightExpr_ != null)
        {
            _rightExpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _rightExpr_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_tab_)
            + toString(_identifier_)
            + toString(_lBr_)
            + toString(_leftExpr_)
            + toString(_rBr_)
            + toString(_eq_)
            + toString(_rightExpr_);
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

        if(_lBr_ == child)
        {
            _lBr_ = null;
            return;
        }

        if(_leftExpr_ == child)
        {
            _leftExpr_ = null;
            return;
        }

        if(_rBr_ == child)
        {
            _rBr_ = null;
            return;
        }

        if(_eq_ == child)
        {
            _eq_ = null;
            return;
        }

        if(_rightExpr_ == child)
        {
            _rightExpr_ = null;
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

        if(_lBr_ == oldChild)
        {
            setLBr((TLBr) newChild);
            return;
        }

        if(_leftExpr_ == oldChild)
        {
            setLeftExpr((PExpression) newChild);
            return;
        }

        if(_rBr_ == oldChild)
        {
            setRBr((TRBr) newChild);
            return;
        }

        if(_eq_ == oldChild)
        {
            setEq((TEq) newChild);
            return;
        }

        if(_rightExpr_ == oldChild)
        {
            setRightExpr((PExpression) newChild);
            return;
        }

    }

    private class Tab_Cast implements Cast
    {
        public Object cast(Object o)
        {
            TTab node = (TTab) o;

            if((node.parent() != null) &&
                (node.parent() != ACalculate2Statement.this))
            {
                node.parent().removeChild(node);
            }

            if((node.parent() == null) ||
                (node.parent() != ACalculate2Statement.this))
            {
                node.parent(ACalculate2Statement.this);
            }

            return node;
        }
    }
}
