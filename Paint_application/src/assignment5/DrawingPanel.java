package assignment5;

import java.awt.Color;


public class DrawingPanel extends javax.swing.JFrame{
    Color[] color = { Color.BLACK, Color.RED, Color.BLUE, Color.GRAY, Color.GREEN, Color.YELLOW, Color.ORANGE };
    UndoRedo undoRedo;
    
    ShapeDeleter deleter;
    public DrawingPanel() {
        initComponents();
        
        undoRedo = new UndoRedo();
        deleter = new ShapeDeleter(DrawPanel);
        filledGroup.add(yes);
        filledGroup.add(no);
        shapesGroup.add(line);
        shapesGroup.add(square);
        shapesGroup.add(rectangle);
        shapesGroup.add(triangle);
        shapesGroup.add(circle);
        no.setSelected(true);
        line.setSelected(true);
        DrawPanel.currentShape = "line";
    }  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filledGroup = new javax.swing.ButtonGroup();
        shapesGroup = new javax.swing.ButtonGroup();
        DrawPanel = new ShapeManipulator();
        Clear = new javax.swing.JButton();
        Undo = new javax.swing.JButton();
        Redo = new javax.swing.JButton();
        Resize = new javax.swing.JButton();
        Move = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        colors = new javax.swing.JComboBox<>();
        no = new javax.swing.JRadioButton();
        yes = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        line = new javax.swing.JRadioButton();
        square = new javax.swing.JRadioButton();
        rectangle = new javax.swing.JRadioButton();
        triangle = new javax.swing.JRadioButton();
        circle = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        Select = new javax.swing.JButton();
        Copy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DrawPanel.setBackground(new java.awt.Color(255, 255, 255));
        DrawPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));


        javax.swing.GroupLayout DrawPanelLayout = new javax.swing.GroupLayout(DrawPanel);
        DrawPanel.setLayout(DrawPanelLayout);
        DrawPanelLayout.setHorizontalGroup(
            DrawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        DrawPanelLayout.setVerticalGroup(
            DrawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        Undo.setText("Undo");
        Undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoActionPerformed(evt);
            }
        });

        Redo.setText("Redo");
        Redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RedoActionPerformed(evt);
            }
        });

        Resize.setText("Resize");
        Resize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResizeActionPerformed(evt);
            }
        });

        Move.setText("Move");
        Move.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoveActionPerformed(evt);
            }
        });

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        colors.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Black", "Red", "Blue", "Gray", "Green", "Yellow", "Orange" }));
        colors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorsActionPerformed(evt);
            }
        });

        no.setText("No");
        no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noActionPerformed(evt);
            }
        });

        yes.setText("Yes");
        yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesActionPerformed(evt);
            }
        });

        jLabel1.setText("Fill Shape:");

        line.setText("Line");
        line.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineActionPerformed(evt);
            }
        });

        square.setText("Square");
        square.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                squareActionPerformed(evt);
            }
        });

        rectangle.setText("Rectangle");
        rectangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectangleActionPerformed(evt);
            }
        });

        triangle.setText("Triangle");
        triangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                triangleActionPerformed(evt);
            }
        });

        circle.setText("Circle");
        circle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circleActionPerformed(evt);
            }
        });

        jLabel2.setText("Shape:");

        Select.setText("Select");
        Select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectActionPerformed(evt);
            }
        });

        Copy.setText("Copy");
        Copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(line)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(square))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(Clear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Undo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rectangle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(triangle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(circle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yes))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Redo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Select)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Move)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Delete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(Resize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Copy)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(no)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(colors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DrawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Undo)
                    .addComponent(Redo)
                    .addComponent(Resize)
                    .addComponent(Move)
                    .addComponent(Delete)
                    .addComponent(Select)
                    .addComponent(Copy)
                    .addComponent(Clear))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(line)
                    .addComponent(square)
                    .addComponent(rectangle)
                    .addComponent(triangle)
                    .addComponent(jLabel2)
                    .addComponent(circle)
                    .addComponent(jLabel1)
                    .addComponent(no)
                    .addComponent(yes)
                    .addComponent(colors, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DrawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        deleter.clearPanel();
        BorderBox.UnSelect();
    }//GEN-LAST:event_ClearActionPerformed

    private void UndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoActionPerformed
        undoRedo.undo();
    }//GEN-LAST:event_UndoActionPerformed

    private void colorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorsActionPerformed
        DrawPanel.changeColor(color[colors.getSelectedIndex()]);
    }//GEN-LAST:event_colorsActionPerformed

    private void noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noActionPerformed
        DrawPanel.isFilled = false;
    }//GEN-LAST:event_noActionPerformed

    private void yesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesActionPerformed
        DrawPanel.isFilled = true;
    }//GEN-LAST:event_yesActionPerformed

    private void RedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RedoActionPerformed
        UndoRedo.redoPressed = true;
        undoRedo.redo();
    }//GEN-LAST:event_RedoActionPerformed

    private void lineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineActionPerformed
        DrawPanel.currentShape = "line";
        DrawPanel.mode = 1;
    }//GEN-LAST:event_lineActionPerformed

    private void squareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squareActionPerformed
        DrawPanel.currentShape = "square";
        DrawPanel.mode = 1;
    }//GEN-LAST:event_squareActionPerformed

    private void rectangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectangleActionPerformed
        DrawPanel.currentShape = "rectangle";
        DrawPanel.mode = 1;
    }//GEN-LAST:event_rectangleActionPerformed

    private void triangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_triangleActionPerformed
        DrawPanel.currentShape = "triangle";
    }//GEN-LAST:event_triangleActionPerformed

    private void circleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circleActionPerformed
        DrawPanel.currentShape = "circle";
        DrawPanel.mode = 1;
    }//GEN-LAST:event_circleActionPerformed

    private void SelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectActionPerformed
        DrawPanel.mode = 2;
    }//GEN-LAST:event_SelectActionPerformed

    private void MoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoveActionPerformed
        DrawPanel.mode = 3;
    }//GEN-LAST:event_MoveActionPerformed

    private void ResizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResizeActionPerformed
        DrawPanel.mode = 4;
    }//GEN-LAST:event_ResizeActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        deleter.deleteSelected();
    }//GEN-LAST:event_DeleteActionPerformed

    private void CopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopyActionPerformed
        DrawPanel.mode = 5;
        Cloner.cloneObject();
    }//GEN-LAST:event_CopyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DrawingPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DrawingPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DrawingPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DrawingPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DrawingPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JButton Copy;
    private javax.swing.JButton Delete;
    private ShapeManipulator DrawPanel;
    private javax.swing.JButton Move;
    private javax.swing.JButton Redo;
    private javax.swing.JButton Resize;
    private javax.swing.JButton Select;
    private javax.swing.JButton Undo;
    private javax.swing.JRadioButton circle;
    private javax.swing.JComboBox<String> colors;
    private javax.swing.ButtonGroup filledGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton line;
    private javax.swing.JRadioButton no;
    private javax.swing.JRadioButton rectangle;
    private javax.swing.ButtonGroup shapesGroup;
    private javax.swing.JRadioButton square;
    private javax.swing.JRadioButton triangle;
    private javax.swing.JRadioButton yes;
    // End of variables declaration//GEN-END:variables
}