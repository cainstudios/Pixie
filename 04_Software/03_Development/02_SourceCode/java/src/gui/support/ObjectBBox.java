/*
 * The MIT License
 *
 * Copyright 2017 Olimpia Popica, Benone Aligica
 *
 * Contact: contact[a(t)]annotate[(d){o}t]zone
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package gui.support;

import common.ConstantsLabeling;
import library.Resize;
import java.awt.Dimension;
import java.awt.Rectangle;

/**
 * The type Object b box.
 *
 * @author Olimpia Popica
 */
public class ObjectBBox extends Objects {

    /**
     * Instantiates a new Object b box.
     */
    public ObjectBBox() {
        super();
    }

    @Override
    public void computeOuterBBoxCurObj() {
    }

    @Override
    public void move(int xOffset, int yOffset, Dimension frameSize) {
        // move only if by moving we do not get out of the image
        if ((outerBBox.x + xOffset >= 0)
                && (outerBBox.y + yOffset >= 0)
                && (outerBBox.x + outerBBox.width + xOffset <= frameSize.width)
                && (outerBBox.y + outerBBox.height + yOffset <= frameSize.height)) {
            // move the outer bounding box; the crop will move as well because it is the same object
            moveBox(xOffset, yOffset, outerBBox);

            // if the label was changed, it means that the user touched it, therefore the segmentation is manual
            segmentationSource = ConstantsLabeling.LABEL_SOURCE_MANUAL;
        }
    }

    @Override
    public boolean remove(Rectangle coordPanelBox, Resize resizeRate) {
        // for boxes, it will always be the erase of the entire object, therefore nothing has to be done inside of the object.
        return false;
    }

    @Override
    public void changeSize(int left, int top, int right, int bottom, Rectangle coordPanelBox, Resize resizeRate, Dimension frameSize) {
        int xTopRight = outerBBox.x + outerBBox.width;
        int xBottomRight = outerBBox.y + outerBBox.height;

        boolean leftCheck = ((outerBBox.x + left >= 0)
                && (outerBBox.x + left < xTopRight));

        boolean topCheck = ((outerBBox.y + top >= 0)
                && (outerBBox.y + top < xBottomRight));

        boolean rightCheck = ((xTopRight + right > outerBBox.x)
                && (xTopRight + right < frameSize.width));

        boolean bottomCheck = ((xBottomRight + bottom > outerBBox.y)
                && (xBottomRight + bottom < frameSize.height));

        if (leftCheck && topCheck && rightCheck && bottomCheck) {
            // change the outer bounding box size; the crop will move as well because it is the same object
            changeSize(left, top, right, bottom, outerBBox);

            // if the label was changed, it means that the user touched it, therefore the segmentation is manual
            segmentationSource = ConstantsLabeling.LABEL_SOURCE_MANUAL;
        }
    }

    /**
     * Changes the size of the box with the specified offsets.
     *
     * @param left - how much should the object be modified on the left side
     * @param top - how much should the object be modified on the top part
     * @param right - how much should the object be modified on the right side
     * @param bottom - how much should the object be modified on the bottom part
     * @param boxPosOrig - the initial position of the selected box in image
     * coordinates
     */
    private void changeSize(int left, int top, int right, int bottom, Rectangle bboxOrigPos) {
        bboxOrigPos.setBounds(bboxOrigPos.x + left, bboxOrigPos.y + top, bboxOrigPos.width + right - left, bboxOrigPos.height + bottom - top);
    }

    @Override
    public boolean contains(Rectangle coordPanelBox, Resize resizeRate) {
        Rectangle outerBBoxPanel = resizeRate.originalToResized(outerBBox);

        return outerBBoxPanel.equals(coordPanelBox);
    }

	@Override
    public void move(int xOffset, int yOffset, Rectangle coordPanelBox, Resize resizeRate, Dimension frameSize) {
        move(xOffset, yOffset, frameSize);
    }
}
