package org.biojava3.core.sequence.views;

import org.biojava3.core.sequence.template.Compound;
import org.biojava3.core.sequence.template.Sequence;
import org.biojava3.core.sequence.template.SequenceMixin;
import org.biojava3.core.sequence.template.SequenceProxyView;

/**
 * For a given sequence this class will return the base at the reversed
 * position i.e. in a sequence of size 10, if you request base 2 you will get
 * back the base at position 9. Sub-views can be made of this class which
 * also respect the reversed calls.
 *
 * @author Andy Yates
 * @param <C> Must be a subtype of @{link Compound}
 */
public class ReversedSequenceView<C extends Compound> extends SequenceProxyView<C> {

    private final int sequenceSize;

    public ReversedSequenceView(Sequence<C> sequence) {
        super(sequence);
        this.sequenceSize = sequence.getLength();
    }

    @Override
    public String getSequenceAsString() {
        return SequenceMixin.toString(this);
    }

    protected int toIndex(int index) {
        return (sequenceSize - index) + 1;
    }

    @Override
    public C getCompoundAt(int position) {
        return super.getCompoundAt(toIndex(position));
    }
}
