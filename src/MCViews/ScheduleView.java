/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCViews;

import MCControllers.MovieController;
import MCControllers.ScheduleController;
import MCControllers.TheaterController;
import MCModels.ArrayListComboBoxModel;
import MCModels.Movie;
import MCModels.Schedule;
import MCModels.Theater;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.LinkedList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class ScheduleView extends javax.swing.JFrame {

    static final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs

    ScheduleController scheduleC = new ScheduleController();
    private List<String> theaterList = new ArrayList<>();
    private int[] theaterIdList = new int[(new TheaterController().selectAll()).size()];

    private ArrayListComboBoxModel modelTheater;
    private List<String> movieList = new ArrayList<>();
    private int[] movieIdList = new int[(new MovieController().SelectAll()).size()];
    private ArrayListComboBoxModel modelMovie;

    int act = 0;
    boolean tableClicked = false;

    /**
     * Creates new form ScheduleView
     */
    public ScheduleView() {
        initComponents();
        loadTheater();
        loadMovie();

    }

    public void loadTheater() {
        TheaterController theaterC = new TheaterController();
        List<Theater> temp = null;
        temp = theaterC.loadTheaters();
        for (int i = 0; i < temp.size(); i++) {
            theaterList.add(temp.get(i).getName());
            theaterIdList[i] = temp.get(i).getId();
        }
        modelTheater = new ArrayListComboBoxModel((ArrayList<String>) theaterList);
        theaterCB.setModel(modelTheater);

    }

    public void loadMovie() {
        MovieController movieC = new MovieController();
        List<Movie> temp = null;
        temp = movieC.SelectAll();
        for (int i = 0; i < temp.size(); i++) {
            movieList.add(temp.get(i).getName());
            movieIdList[i] = temp.get(i).getId();
        }
        modelMovie = new ArrayListComboBoxModel((ArrayList<String>) movieList);
        movieCB.setModel(modelMovie);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        scheduleTable = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        modifyBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        theaterCB = new javax.swing.JComboBox<>();
        movieCB = new javax.swing.JComboBox<>();
        theaterLabel = new javax.swing.JLabel();
        movieLabel = new javax.swing.JLabel();
        datetimeLabel = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        scheduleDateTimePicker = new com.github.lgooddatepicker.components.DateTimePicker();
        searchTextField = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        scheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Theater", "Movie", "Begin Time", "End Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(scheduleTable);
        if (scheduleTable.getColumnModel().getColumnCount() > 0) {
            scheduleTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MCImage/addIcon32px.png"))); // NOI18N
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        modifyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MCImage/modifyIcon32px.png"))); // NOI18N
        modifyBtn.setText("Modify");
        modifyBtn.setToolTipText("");
        modifyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyBtnActionPerformed(evt);
            }
        });

        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MCImage/deleteIcon32px.png"))); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MCImage/refeshIcon32px.png"))); // NOI18N
        refreshBtn.setText("Refresh");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        theaterCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        movieCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        theaterLabel.setText("Theater");

        movieLabel.setText("Movie");

        datetimeLabel.setText("Date & Time");

        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MCImage/saveIcon32px.png"))); // NOI18N
        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(theaterLabel)
                            .addComponent(movieLabel)
                            .addComponent(datetimeLabel))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(theaterCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(movieCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scheduleDateTimePicker, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(saveBtn)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(theaterCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(theaterLabel))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(movieCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(movieLabel))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datetimeLabel)
                    .addComponent(scheduleDateTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(saveBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        searchTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MCImage/searchIcon32px.png"))); // NOI18N
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modifyBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshBtn)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(searchBtn))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBtn)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addBtn)
                            .addComponent(modifyBtn)
                            .addComponent(deleteBtn)
                            .addComponent(refreshBtn))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:

        theaterCB.setEnabled(true);
        movieCB.setEnabled(true);
        scheduleDateTimePicker.datePicker.setEnabled(true);
        scheduleDateTimePicker.timePicker.setEnabled(true);

        act = 1;
    }//GEN-LAST:event_addBtnActionPerformed

    private void modifyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyBtnActionPerformed
        // TODO add your handling code here:

        if (tableClicked == true) {
            theaterCB.setEnabled(true);
            //String theaterName = new TheaterController().select("theaterId=" + scheduleTable.getValueAt(scheduleTable.getSelectedRow(), 1).toString()).get(0).getName();
            theaterCB.getModel().setSelectedItem(scheduleTable.getValueAt(scheduleTable.getSelectedRow(), 1).toString());

            movieCB.setEnabled(true);
            //String movieName = new MovieController().select("movieId=" + scheduleTable.getValueAt(scheduleTable.getSelectedRow(), 2).toString()).get(0).getName();
            movieCB.getModel().setSelectedItem(scheduleTable.getValueAt(scheduleTable.getSelectedRow(), 2).toString());

            SimpleDateFormat pFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date datetime = null;
            try {
                datetime = pFormatter.parse(scheduleTable.getValueAt(scheduleTable.getSelectedRow(), 3).toString());
            } catch (ParseException ex) {
                Logger.getLogger(ScheduleView.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(datetime);

            scheduleDateTimePicker.datePicker.setEnabled(true);
            scheduleDateTimePicker.datePicker.setDateToToday();

            scheduleDateTimePicker.timePicker.setEnabled(true);
            scheduleDateTimePicker.timePicker.setTimeToNow();

            // scheduleDateTimePicker.setDateTimePermissive( (LocalDateTime) scheduleTable.getValueAt(scheduleTable.getSelectedRow(), 3));
            act = 2;
        } else {
            JOptionPane.showMessageDialog(null, "Please select a schedule");
        }
    }//GEN-LAST:event_modifyBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:

        if (tableClicked == true) {
            int res = scheduleC.Delete((int) scheduleTable.getValueAt(scheduleTable.getSelectedRow(), 0));
            int check = JOptionPane.showConfirmDialog(jScrollPane1, "Are you sure delete this movie?", "Delete", JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "Deleted successfully");
                } else if (res == 0) {
                    JOptionPane.showMessageDialog(null, "Unable to delete");
                }

                refreshBtnActionPerformed(evt);
                act = 0;

            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a schedule");
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed

        scheduleTable.clearSelection();

        DefaultTableModel model = (DefaultTableModel) scheduleTable.getModel();

        model.setRowCount(0);   //clear data table

        SimpleDateFormat pFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<Schedule> scheduleList = scheduleC.SelectAll();
        Object rowData[] = new Object[5];

        for (int i = 0; i < scheduleList.size(); i++) {
            rowData[0] = scheduleList.get(i).getId();
            rowData[1] = new TheaterController().select("theaterId=" + scheduleList.get(i).getTheaterId()).get(0).getName();
            rowData[2] = new MovieController().select("movieId=" + scheduleList.get(i).getMovieId()).get(0).getName();
            rowData[3] = scheduleList.get(i).getTime();

            //caculate end time by add duration
            Calendar date = Calendar.getInstance();
            date.setTime(scheduleList.get(i).getTime());
            long t = date.getTimeInMillis();
            Date afterAddingDuration = new Date(t + (new MovieController().select("movieId=" + scheduleList.get(i).getMovieId()).get(0).getDuration() * ONE_MINUTE_IN_MILLIS));

            rowData[4] = pFormatter.format(afterAddingDuration);
            System.out.println(scheduleList.get(i).getTime());
            model.addRow(rowData);
        }

        theaterCB.setEnabled(false);
        movieCB.setEnabled(false);
        scheduleDateTimePicker.datePicker.setEnabled(false);
        scheduleDateTimePicker.timePicker.setEnabled(false);
        tableClicked = false;

        scheduleTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                //do some actions here, for example
                //print first column value from selected row
                //System.out.println(scheduleTable.getValueAt(table.getSelectedRow(), 0).toString());
                theaterCB.setEnabled(false);
                movieCB.setEnabled(false);
                scheduleDateTimePicker.datePicker.setEnabled(false);
                scheduleDateTimePicker.timePicker.setEnabled(false);
                tableClicked = true;
            }
        });
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        if (act == 1) //save add info
        {

            Schedule sched = new Schedule();
            //modelTheater.setSelectedItem(theaterCB.getSelectedItem());
            sched.setTheaterId(theaterIdList[theaterCB.getSelectedIndex()]);
            System.out.println(sched.getTheaterId());

            sched.setMovieId(movieIdList[movieCB.getSelectedIndex()]);
            System.out.println(sched.getMovieId());

            String datetime = "";
            System.out.println(scheduleDateTimePicker.datePicker.getDateStringOrEmptyString());
            System.out.println(scheduleDateTimePicker.timePicker.getTimeStringOrEmptyString());

            scheduleDateTimePicker.datePicker.getSettings().setAllowEmptyDates(false);
            scheduleDateTimePicker.timePicker.getSettings().setAllowEmptyTimes(false);

            datetime += scheduleDateTimePicker.datePicker.getDateStringOrEmptyString() + " ";
            datetime += scheduleDateTimePicker.timePicker.getTimeStringOrEmptyString() + ":00";

            System.out.println(datetime);

            SimpleDateFormat pFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm");  
            try {
                sched.setTime(pFormatter.parse(datetime));
            } catch (ParseException ex) {
                Logger.getLogger(ScheduleView.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(sched.getTime());
            boolean dateTimeCheck = false;
            Date todayDate = null;
            try {
                todayDate = pFormatter.parse(pFormatter.format(new Date()));
            } catch (ParseException ex) {
                Logger.getLogger(ScheduleView.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (dateTimeCheck == false) {

                //check if choosing datetime after now time 
                if (sched.getTime().compareTo(todayDate) >= 0) {
                    dateTimeCheck = true;

                    //get list schedule of choosing theater
                    List<Schedule> checkSchedList = scheduleC.Select("theaterId=" + sched.getTheaterId());

                    boolean timeCollide = false;
                    int schedCollideId = 0;
                    //check if there is any collide schedule time
                    for (int i = 0; i < checkSchedList.size(); i++) {
                        //get begin time of a shedule
                        Calendar beginTime = Calendar.getInstance();
                        Date beginCheckTime = checkSchedList.get(i).getTime();
                        try {
                            beginCheckTime = pFormatter.parse(pFormatter.format(beginCheckTime));
                        } catch (ParseException ex) {
                            Logger.getLogger(ScheduleView.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        beginTime.setTime(beginCheckTime);
                        System.out.println("Begin time: " + beginCheckTime);

                        //get end time of a schedule
                        long t = beginTime.getTimeInMillis();
                        Date afterAddingDuration = new Date(t + (new MovieController().select("movieId=" + checkSchedList.get(i).getMovieId()).get(0).getDuration() * ONE_MINUTE_IN_MILLIS));
                        try {
                            afterAddingDuration = pFormatter.parse(pFormatter.format(afterAddingDuration));
                        } catch (ParseException ex) {
                            Logger.getLogger(ScheduleView.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        System.out.println("End time: " + afterAddingDuration);

                        //get choosing begin time
                        Calendar schedBeginTime = Calendar.getInstance();
                        schedBeginTime.setTime(sched.getTime());
                        System.out.println("Sched time: " + sched.getTime());

                        //get choosing end time
                        long schedT = schedBeginTime.getTimeInMillis();
                        Date schedAfterAddingDuration = new Date(schedT + (new MovieController().select("movieId=" + checkSchedList.get(i).getMovieId()).get(0).getDuration() * ONE_MINUTE_IN_MILLIS));
                        try {
                            schedAfterAddingDuration = pFormatter.parse(pFormatter.format(schedAfterAddingDuration));
                        } catch (ParseException ex) {
                            Logger.getLogger(ScheduleView.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        //check if user choose beginTime collide with another schedule time
                        if (sched.getTime().after(checkSchedList.get(i).getTime()) && sched.getTime().before(afterAddingDuration)) {

                            timeCollide = true;
                            schedCollideId = checkSchedList.get(i).getId();
                        }

                        //check if user endTime collide with another schedule time
                        if (schedAfterAddingDuration.after(checkSchedList.get(i).getTime()) && schedAfterAddingDuration.before(afterAddingDuration)) {

                            timeCollide = true;
                            schedCollideId = checkSchedList.get(i).getId();
                        }
                    }
                    if (timeCollide == false) {
                        //dateTimeCheck = true;
                        int res = scheduleC.Add(sched);
                        if (res > 0) {
                            JOptionPane.showMessageDialog(null, "Saved - add new info");
                        } else {
                            JOptionPane.showMessageDialog(null, "Unable to save");
                        }
                        refreshBtnActionPerformed(evt);
                        act = 0;
                        theaterCB.setEnabled(false);
                        movieCB.setEnabled(false);
                        scheduleDateTimePicker.datePicker.setEnabled(false);
                        scheduleDateTimePicker.timePicker.setEnabled(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Have a collision in shedule time!!!\n Collided with schedule time ID: " + schedCollideId);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Date time not valid");
                    dateTimeCheck = true;
                }
            }

        } else if (act == 2) {

            Schedule sched = new Schedule();
            //modelTheater.setSelectedItem(theaterCB.getSelectedItem());

            sched.setId((int) scheduleTable.getValueAt(scheduleTable.getSelectedRow(), 0));

            sched.setTheaterId(theaterIdList[theaterCB.getSelectedIndex()]);
            System.out.println(sched.getTheaterId());

            sched.setMovieId(movieIdList[movieCB.getSelectedIndex()]);
            System.out.println(sched.getMovieId());

            String datetime = "";

            scheduleDateTimePicker.datePicker.getSettings().setAllowEmptyDates(false);
            scheduleDateTimePicker.timePicker.getSettings().setAllowEmptyTimes(false);

            System.out.println(scheduleDateTimePicker.datePicker.getDateStringOrEmptyString());
            System.out.println(scheduleDateTimePicker.timePicker.getTimeStringOrEmptyString());

            datetime += scheduleDateTimePicker.datePicker.getDateStringOrEmptyString() + " ";
            datetime += scheduleDateTimePicker.timePicker.getTimeStringOrEmptyString() + ":00";

            System.out.println(datetime);

            SimpleDateFormat pFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm");  

            try {
                sched.setTime(pFormatter.parse(datetime));
            } catch (ParseException ex) {
                Logger.getLogger(ScheduleView.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(sched.getTime());
            //System.out.println("after: "+formatter.format(sched.getTime()));

            boolean dateTimeCheck = false;
            Date todayDate = null;
            try {
                todayDate = pFormatter.parse(pFormatter.format(new Date()));
            } catch (ParseException ex) {
                Logger.getLogger(ScheduleView.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (dateTimeCheck == false) {

                //check if choosing datetime after now time 
                if (sched.getTime().compareTo(todayDate) >= 0) {
                    dateTimeCheck = true;

                    //get list schedule of choosing theater
                    List<Schedule> checkSchedList = scheduleC.Select("theaterId=" + sched.getTheaterId());

                    boolean timeCollide = false;
                    int schedCollideId = 0;
                    //check if there is any collide schedule time
                    for (int i = 0; i < checkSchedList.size(); i++) {
                        //get begin time of a shedule
                        Calendar beginTime = Calendar.getInstance();
                        Date beginCheckTime = checkSchedList.get(i).getTime();
                        try {
                            beginCheckTime = pFormatter.parse(pFormatter.format(beginCheckTime));
                        } catch (ParseException ex) {
                            Logger.getLogger(ScheduleView.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        beginTime.setTime(beginCheckTime);
                        System.out.println("Begin time: " + beginCheckTime);

                        //get end time of a schedule
                        long t = beginTime.getTimeInMillis();
                        Date afterAddingDuration = new Date(t + (new MovieController().select("movieId=" + checkSchedList.get(i).getMovieId()).get(0).getDuration() * ONE_MINUTE_IN_MILLIS));
                        try {
                            afterAddingDuration = pFormatter.parse(pFormatter.format(afterAddingDuration));
                        } catch (ParseException ex) {
                            Logger.getLogger(ScheduleView.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        System.out.println("End time: " + afterAddingDuration);

                        //get choosing begin time
                        Calendar schedBeginTime = Calendar.getInstance();
                        schedBeginTime.setTime(sched.getTime());
                        System.out.println("Sched time: " + sched.getTime());

                        //get choosing end time
                        long schedT = schedBeginTime.getTimeInMillis();
                        Date schedAfterAddingDuration = new Date(schedT + (new MovieController().select("movieId=" + checkSchedList.get(i).getMovieId()).get(0).getDuration() * ONE_MINUTE_IN_MILLIS));
                        try {
                            schedAfterAddingDuration = pFormatter.parse(pFormatter.format(schedAfterAddingDuration));
                        } catch (ParseException ex) {
                            Logger.getLogger(ScheduleView.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        //check if user choose beginTime collide with another schedule time
                        if (sched.getTime().after(checkSchedList.get(i).getTime()) && sched.getTime().before(afterAddingDuration)) {

                            timeCollide = true;
                            schedCollideId = checkSchedList.get(i).getId();
                        }

                        //check if user endTime collide with another schedule time
                        if (schedAfterAddingDuration.after(checkSchedList.get(i).getTime()) && schedAfterAddingDuration.before(afterAddingDuration)) {

                            timeCollide = true;
                            schedCollideId = checkSchedList.get(i).getId();
                        }
                    }
                    if (timeCollide == false) {
                        //dateTimeCheck = true;
                        int res = scheduleC.Modify(sched);
                        if (res > 0) {
                            JOptionPane.showMessageDialog(null, "Saved - add new info");
                        } else {
                            JOptionPane.showMessageDialog(null, "Unable to save");
                        }
                        refreshBtnActionPerformed(evt);
                        act = 0;
                        theaterCB.setEnabled(false);
                        movieCB.setEnabled(false);
                        scheduleDateTimePicker.datePicker.setEnabled(false);
                        scheduleDateTimePicker.timePicker.setEnabled(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Have a collision in shedule time!!!\n Collided with schedule time ID: " + schedCollideId);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Date time not valid");
                    dateTimeCheck = true;
                }
            }
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:

        refreshBtnActionPerformed(null);

    }//GEN-LAST:event_formComponentShown

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:

        SimpleDateFormat pFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        scheduleTable.clearSelection();

        DefaultTableModel model = (DefaultTableModel) scheduleTable.getModel();

        model.setRowCount(0);   //clear data table

        MovieController movieC = new MovieController();

        List<Movie> movieList = movieC.select("movieName like '%" + searchTextField.getText() + "%'");
        List<Schedule> scheduleList = new LinkedList<Schedule>();
        for (int i = 0; i < movieList.size(); i++) {
            scheduleList.addAll(scheduleC.Select("movieId=" + movieList.get(i).getId()));
        }

        Object rowData[] = new Object[5];

        for (int i = 0; i < scheduleList.size(); i++) {
            rowData[0] = scheduleList.get(i).getId();
            rowData[1] = new TheaterController().select("theaterId=" + scheduleList.get(i).getTheaterId()).get(0).getName();
            rowData[2] = new MovieController().select("movieId=" + scheduleList.get(i).getMovieId()).get(0).getName();
            rowData[3] = scheduleList.get(i).getTime();

            //caculate end time by add duration
            Calendar date = Calendar.getInstance();
            date.setTime(scheduleList.get(i).getTime());
            long t = date.getTimeInMillis();
            Date afterAddingDuration = new Date(t + (new MovieController().select("movieId=" + scheduleList.get(i).getMovieId()).get(0).getDuration() * ONE_MINUTE_IN_MILLIS));

            rowData[4] = pFormatter.format(afterAddingDuration);
            System.out.println(scheduleList.get(i).getTime());
            model.addRow(rowData);
        }

        tableClicked = false;

        scheduleTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                theaterCB.setEnabled(false);
                movieCB.setEnabled(false);
                scheduleDateTimePicker.datePicker.setEnabled(false);
                scheduleDateTimePicker.timePicker.setEnabled(false);

                tableClicked = true;
            }
        });
    }//GEN-LAST:event_searchBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ScheduleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScheduleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScheduleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScheduleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScheduleView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel datetimeLabel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JButton modifyBtn;
    private javax.swing.JComboBox<String> movieCB;
    private javax.swing.JLabel movieLabel;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton saveBtn;
    private com.github.lgooddatepicker.components.DateTimePicker scheduleDateTimePicker;
    private javax.swing.JTable scheduleTable;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JComboBox<String> theaterCB;
    private javax.swing.JLabel theaterLabel;
    // End of variables declaration//GEN-END:variables
}
