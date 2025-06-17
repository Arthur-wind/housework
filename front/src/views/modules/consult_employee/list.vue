<template>
  <div class="main-content">
    <!-- 列表页 -->
    <div v-if="showFlag">
      <el-form :inline="true" :model="searchForm" class="form-content">
        <el-row  :gutter="20" class="slt" :style="{justifyContent:contents.searchBoxPosition=='1'?'flex-start':contents.searchBoxPosition=='2'?'center':'flex-end'}">
                <el-form-item :label="contents.inputTitle == 1 ? '雇员姓名' : ''">
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 1" prefix-icon="el-icon-search" v-model="searchForm.employee_name" placeholder="雇员姓名" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 2" suffix-icon="el-icon-search" v-model="searchForm.employee_name" placeholder="雇员姓名" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 0" v-model="searchForm.employee_name" placeholder="雇员姓名" clearable></el-input>
                </el-form-item>
                <el-form-item :label="contents.inputTitle == 1 ? '姓名' : ''">
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 1" prefix-icon="el-icon-search" v-model="searchForm.employer_name" placeholder="姓名" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 2" suffix-icon="el-icon-search" v-model="searchForm.employer_name" placeholder="姓名" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 0" v-model="searchForm.employer_name" placeholder="姓名" clearable></el-input>
                </el-form-item>
		<el-form-item class="select" label="是否通过" prop="is_reviewed">
		  <el-select  @change="is_reviewedChange" clearable v-model="searchForm.is_reviewed" placeholder="是否通过">
		    <el-option
			v-for="(item,index) in is_reviewedOptions"
			v-bind:key="index"
			:label="item"
			:value="item">
		    </el-option>
		  </el-select>
		</el-form-item>
          <el-form-item>
            <el-button v-if="contents.searchBtnIcon == 1 && contents.searchBtnIconPosition == 1" icon="el-icon-search" type="success" @click="search()">{{ contents.searchBtnFont == 1?'查询':'' }}</el-button>
            <el-button v-if="contents.searchBtnIcon == 1 && contents.searchBtnIconPosition == 2" type="success" @click="search()">{{ contents.searchBtnFont == 1?'查询':'' }}<i class="el-icon-search el-icon--right"/></el-button>
            <el-button v-if="contents.searchBtnIcon == 0" type="success" @click="search()">{{ contents.searchBtnFont == 1?'查询':'' }}</el-button>
          </el-form-item>
        </el-row>

        <el-row class="ad" :style="{justifyContent:contents.btnAdAllBoxPosition=='1'?'flex-start':contents.btnAdAllBoxPosition=='2'?'center':'flex-end'}">
          <el-form-item>
            <el-button
              v-if="isAuth('consult_employee','新增') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 1"
              type="success"
              icon="el-icon-plus"
              @click="addOrUpdateHandler()"
            >{{ contents.btnAdAllFont == 1?'新增':'' }}</el-button>
            <el-button
              v-if="isAuth('consult_employee','新增') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 2"
              type="success"
              @click="addOrUpdateHandler()"
            >{{ contents.btnAdAllFont == 1?'新增':'' }}<i class="el-icon-plus el-icon--right" /></el-button>
            <el-button
              v-if="isAuth('consult_employee','新增') && contents.btnAdAllIcon == 0"
              type="success"
              @click="addOrUpdateHandler()"
            >{{ contents.btnAdAllFont == 1?'新增':'' }}</el-button>
            <el-button
              v-if="isAuth('consult_employee','删除') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 1 && contents.tableSelection"
              :disabled="dataListSelections.length <= 0"
              type="danger"
              icon="el-icon-delete"
              @click="deleteHandler()"
            >{{ contents.btnAdAllFont == 1?'删除':'' }}</el-button>
            <el-button
              v-if="isAuth('consult_employee','删除') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 2 && contents.tableSelection"
              :disabled="dataListSelections.length <= 0"
              type="danger"
              @click="deleteHandler()"
            >{{ contents.btnAdAllFont == 1?'删除':'' }}<i class="el-icon-delete el-icon--right" /></el-button>
            <el-button
              v-if="isAuth('consult_employee','删除') && contents.btnAdAllIcon == 0 && contents.tableSelection"
              :disabled="dataListSelections.length <= 0"
              type="danger"
              @click="deleteHandler()"
            >{{ contents.btnAdAllFont == 1?'删除':'' }}</el-button>





          </el-form-item>
        </el-row>
      </el-form>
      <div class="table-content">
        <el-table class="tables" :size="contents.tableSize" :show-header="contents.tableShowHeader"
            :header-row-style="headerRowStyle" :header-cell-style="headerCellStyle"
            :border="contents.tableBorder"
            :fit="contents.tableFit"
            :stripe="contents.tableStripe"
            :style="{width: '100%',fontSize:contents.tableContentFontSize,color:contents.tableContentFontColor}"
            v-if="isAuth('consult_employee','查看')"
            :data="dataList"
            v-loading="dataListLoading"
            @selection-change="selectionChangeHandler">
            <el-table-column  v-if="contents.tableSelection"
                type="selection"
                :header-align="contents.tableAlign"
                align="center"
                width="50">
            </el-table-column>
            <el-table-column label="索引" :align="contents.tableAlign"  v-if="contents.tableIndex" type="index" width="50" />
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="title"
                   :header-align="contents.tableAlign"
		    label="标题">
		     <template slot-scope="scope">
                       {{scope.row.title}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="consult_time"
                   :header-align="contents.tableAlign"
		    label="咨询时间">
		     <template slot-scope="scope">
                       {{scope.row.consult_time}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="employee_account"
                   :header-align="contents.tableAlign"
		    label="雇员账号">
		     <template slot-scope="scope">
                       {{scope.row.employee_account}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="employee_name"
                   :header-align="contents.tableAlign"
		    label="雇员姓名">
		     <template slot-scope="scope">
                       {{scope.row.employee_name}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="employer_account"
                   :header-align="contents.tableAlign"
		    label="账号">
		     <template slot-scope="scope">
                       {{scope.row.employer_account}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="employer_name"
                   :header-align="contents.tableAlign"
		    label="姓名">
		     <template slot-scope="scope">
                       {{scope.row.employer_name}}
                     </template>
                </el-table-column>
              <el-table-column :sortable="contents.tableSortable" :align="contents.tableAlign" 
                  prop="review_comment"
                 :header-align="contents.tableAlign"
                  label="审核回复">
              </el-table-column>
              <el-table-column :sortable="contents.tableSortable" :align="contents.tableAlign" 
                  prop="is_reviewed"
                 :header-align="contents.tableAlign"
                  label="审核状态">
                  <template slot-scope="scope">
                    <span style="margin-right:10px">{{scope.row.is_reviewed=='是'?'通过':'未通过'}}</span>
                  </template>
              </el-table-column>
              <el-table-column :sortable="contents.tableSortable" :align="contents.tableAlign" 
                  v-if="isAuth('consult_employee','审核')"
                  prop="is_reviewed"
                 :header-align="contents.tableAlign"
                  label="审核">
                  <template slot-scope="scope">
                    <el-button  type="text" icon="el-icon-edit" size="small" @click="shDialog(scope.row)">审核</el-button>
                  </template>
              </el-table-column>
            <el-table-column width="300" :align="contents.tableAlign" 
               :header-align="contents.tableAlign"
                label="操作">
                <template slot-scope="scope">
                <el-button v-if="isAuth('consult_employee','查看') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="success" icon="el-icon-tickets" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">{{ contents.tableBtnFont == 1?'详情':'' }}</el-button>
                <el-button v-if="isAuth('consult_employee','查看') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">{{ contents.tableBtnFont == 1?'详情':'' }}<i class="el-icon-tickets el-icon--right" /></el-button>
                <el-button v-if="isAuth('consult_employee','查看') && contents.tableBtnIcon == 0" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">{{ contents.tableBtnFont == 1?'详情':'' }}</el-button>
                <el-button v-if=" isAuth('consult_employee','修改') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="primary" icon="el-icon-edit" size="mini" @click="addOrUpdateHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'修改':'' }}</el-button>
                <el-button v-if=" isAuth('consult_employee','修改') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'修改':'' }}<i class="el-icon-edit el-icon--right" /></el-button>
                <el-button v-if=" isAuth('consult_employee','修改') && contents.tableBtnIcon == 0" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'修改':'' }}</el-button>




                <el-button v-if="isAuth('consult_employee','删除') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="danger" icon="el-icon-delete" size="mini" @click="deleteHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'删除':'' }}</el-button>
                <el-button v-if="isAuth('consult_employee','删除') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="danger" size="mini" @click="deleteHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'删除':'' }}<i class="el-icon-delete el-icon--right" /></el-button>
                <el-button v-if="isAuth('consult_employee','删除') && contents.tableBtnIcon == 0" type="danger" size="mini" @click="deleteHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'删除':'' }}</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
          clsss="pages"
          :layout="layouts"
          @size-change="sizeChangeHandle"
          @current-change="currentChangeHandle"
          :current-page="pageIndex"
          :page-sizes="[10, 20, 50, 100]"
          :page-size="Number(contents.pageEachNum)"
          :total="totalPage"
          :small="contents.pageStyle"
          class="pagination-content"
          :background="contents.pageBtnBG"
          :style="{textAlign:contents.pagePosition==1?'left':contents.pagePosition==2?'center':'right'}"
        ></el-pagination>
      </div>
    </div>
    <!-- 添加/修改页面  将父组件的search方法传递给子组件-->
    <add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>


    <el-dialog
      title="审核"
      :visible.sync="is_reviewedVisiable"
      width="50%">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="审核状态">
          <el-select v-model="shForm.is_reviewed" placeholder="审核状态">
            <el-option label="通过" value="是"></el-option>
            <el-option label="不通过" value="否"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="内容">
          <el-input type="textarea" :rows="8" v-model="shForm.review_comment"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="shDialog">取 消</el-button>
        <el-button type="primary" @click="shHandler">确 定</el-button>
      </span>
    </el-dialog>



  </div>
</template>
<script>
import axios from 'axios'
import AddOrUpdate from "./add-or-update";
export default {
  data() {
    return {
      searchForm: {
        key: ""
      },
      form:{},
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      is_reviewedVisiable: false,
      shForm: {},
      chartVisiable: false,
      addOrUpdateFlag:false,
contents: {
  "searchBtnFontColor": "rgba(0, 0, 0, 1)",
  "pagePosition": "2",
  "inputFontSize": "14px",
  "inputBorderRadius": "5px",
  "tableBtnDelFontColor": "rgba(0, 0, 0, 1)",
  "tableBtnIconPosition": "1",
  "searchBtnHeight": "40px",
  "tableBgColor": "rgba(245, 245, 245, 1)", // 灰色
  "inputIconColor": "rgba(0, 0, 0, 1)",
  "searchBtnBorderRadius": "5px",
  "tableStripe": true,
  "btnAdAllWarnFontColor": "rgba(0, 0, 0, 1)", // 黑色
  "tableBtnDelBgColor": "rgba(245, 245, 245, 1)", // 灰色
  "searchBtnIcon": "1",
  "tableSize": "medium",
  "searchBtnBorderStyle": "solid",
  "text": {
    "padding": "0px 0px 0px 0px",
    "boxShadow": "0 0 0px rgba(0,0,0,.1)",
    "margin": "10px  auto",
    "borderColor": "rgba(0,0,0,.3)",
    "backgroundColor": "rgba(245, 245, 245, 1)", // 灰色
    "color": "rgba(0, 0, 0, 1)", // 黑色
    "borderRadius": "0",
    "borderWidth": "0",
    "width": "800px",
    "lineHeight": "60px",
    "fontSize": "30px",
    "borderStyle": "solid"
  },
  "tableSelection": true,
  "searchBtnBorderWidth": "0",
  "tableContentFontSize": "14px",
  "searchBtnBgColor": "rgba(245, 245, 245, 1)", // 灰色
  "inputTitleSize": "15px",
  "btnAdAllBorderColor": "rgba(200, 200, 200, 1)", // 灰色边框
  "pageJumper": true,
  "btnAdAllIconPosition": "1",
  "searchBoxPosition": "1",
  "tableBtnDetailFontColor": "rgba(0, 0, 0, 1)", // 黑色
  "tableBtnHeight": "40px",
  "pagePager": true,
  "searchBtnBorderColor": "rgba(200, 200, 200, 1)", // 灰色边框
  "tableHeaderFontColor": "rgba(0, 0, 0, 1)", // 黑色
  "inputTitle": "1",
  "tableBtnBorderRadius": "5px",
  "btnAdAllFont": "1",
  "btnAdAllDelFontColor": "rgba(0, 0, 0, 1)", // 黑色
  "tableBtnIcon": "1",
  "btnAdAllHeight": "40px",
  "btnAdAllWarnBgColor": "rgba(245, 245, 245, 1)", // 灰色
  "btnAdAllBorderWidth": "0",
  "tableStripeFontColor": "rgba(0, 0, 0, 1)", // 黑色
  "tableBtnBorderStyle": "solid",
  "inputHeight": "40px",
  "btnAdAllBorderRadius": "5px",
  "btnAdAllDelBgColor": "rgba(245, 245, 245, 1)", // 灰色
  "pagePrevNext": true,
  "btnAdAllAddBgColor": "rgba(245, 245, 245, 1)", // 灰色
  "searchBtnFont": "1",
  "tableIndex": true,
  "btnAdAllIcon": "1",
  "tableSortable": false,
  "pageSizes": true,
  "tableFit": true,
  "pageBtnBG": true,
  "searchBtnFontSize": "14px",
  "tableBtnEditBgColor": "rgba(245, 245, 245, 1)", // 灰色
  "box": {
    "padding": "12px 0px 0px 0px",
    "boxShadow": "0 0 6px rgba(0,0,0,0)",
    "flag": "2",
    "backgroundImage": "",
    "background": "rgba(245, 245, 245, 1)" // 灰色
  },
  "inputBorderWidth": "0",
  "inputFontPosition": "2",
  "inputFontColor": "rgba(0, 0, 0, 1)", // 黑色
  "pageEachNum": 10,
  "tableHeaderBgColor": "rgba(220, 220, 220, 1)", // 浅灰色表头
  "inputTitleColor": "rgba(0, 0, 0, 1)", // 黑色
  "btnAdAllBoxPosition": "1",
  "tableBtnDetailBgColor": "rgba(245, 245, 245, 1)", // 灰色
  "inputIcon": "1",
  "searchBtnIconPosition": "1",
  "btnAdAllFontSize": "16px",
  "inputBorderStyle": "solid",
  "tableHoverFontColor": "#000", // 黑色
  "inputBgColor": "rgba(245, 245, 245, 1)", // 灰色
  "pageStyle": false,
  "pageTotal": true,
  "btnAdAllAddFontColor": "rgba(0, 0, 0, 1)", // 黑色
  "tableBtnFont": "1",
  "tableContentFontColor": "rgba(0, 0, 0, 1)", // 黑色
  "inputBorderColor": "rgba(200, 200, 200, 1)", // 灰色边框
  "tableShowHeader": true,
  "tableHoverBgColor": "rgba(220, 220, 220, 1)", // 浅灰色hover
  "tableBtnFontSize": "15px",
  "tableBtnBorderColor": "rgba(200, 200, 200, 1)", // 灰色边框
  "inputIconPosition": "1",
  "tableBorder": true,
  "btnAdAllBorderStyle": "solid",
  "tableBtnBorderWidth": "6px 0px 6px 0px",
  "tableStripeBgColor": "rgba(245, 245, 245, 1)", // 灰色
  "tableBtnEditFontColor": "rgba(0, 0, 0, 1)", // 黑色
  "tableAlign": "center"
},      layouts: '',


    };
  },
  created() {
    this.init();
    this.getDataList();
    this.contentStyleChange()
  },
  mounted() {

  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
  },
  methods: {

    contentStyleChange() {
      this.contentSearchStyleChange()
      this.contentBtnAdAllStyleChange()
      this.contentSearchBtnStyleChange()
      this.contentTableBtnStyleChange()
      this.contentPageStyleChange()
    },
    contentSearchStyleChange() {
      this.$nextTick(()=>{
        document.querySelectorAll('.form-content .slt .el-input__inner').forEach(el=>{
          let textAlign = 'left'
          if(this.contents.inputFontPosition == 2) textAlign = 'center'
          if(this.contents.inputFontPosition == 3) textAlign = 'right'
          el.style.textAlign = textAlign
          el.style.height = this.contents.inputHeight
          el.style.lineHeight = this.contents.inputHeight
          el.style.color = this.contents.inputFontColor
          el.style.fontSize = this.contents.inputFontSize
          el.style.borderWidth = this.contents.inputBorderWidth
          el.style.borderStyle = this.contents.inputBorderStyle
          el.style.borderColor = this.contents.inputBorderColor
          el.style.borderRadius = this.contents.inputBorderRadius
          el.style.backgroundColor = this.contents.inputBgColor
        })
        if(this.contents.inputTitle) {
          document.querySelectorAll('.form-content .slt .el-form-item__label').forEach(el=>{
            el.style.color = this.contents.inputTitleColor
            el.style.fontSize = this.contents.inputTitleSize
            el.style.lineHeight = this.contents.inputHeight
          })
        }
        setTimeout(()=>{
          document.querySelectorAll('.form-content .slt .el-input__prefix').forEach(el=>{
            el.style.color = this.contents.inputIconColor
            el.style.lineHeight = this.contents.inputHeight
          })
          document.querySelectorAll('.form-content .slt .el-input__suffix').forEach(el=>{
            el.style.color = this.contents.inputIconColor
            el.style.lineHeight = this.contents.inputHeight
          })
          document.querySelectorAll('.form-content .slt .el-input__icon').forEach(el=>{
            el.style.lineHeight = this.contents.inputHeight
          })
        },10)

      })
    },
    // 搜索按钮
    contentSearchBtnStyleChange() {
      this.$nextTick(()=>{
        document.querySelectorAll('.form-content .slt .el-button--success').forEach(el=>{
          el.style.height = this.contents.searchBtnHeight
          el.style.color = this.contents.searchBtnFontColor
          el.style.fontSize = this.contents.searchBtnFontSize
          el.style.borderWidth = this.contents.searchBtnBorderWidth
          el.style.borderStyle = this.contents.searchBtnBorderStyle
          el.style.borderColor = this.contents.searchBtnBorderColor
          el.style.borderRadius = this.contents.searchBtnBorderRadius
          el.style.backgroundColor = this.contents.searchBtnBgColor
        })
      })
    },
    // 新增、批量删除
    contentBtnAdAllStyleChange() {
      this.$nextTick(()=>{
        document.querySelectorAll('.form-content .ad .el-button--success').forEach(el=>{
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllAddFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllAddBgColor
        })
        document.querySelectorAll('.form-content .ad .el-button--danger').forEach(el=>{
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllDelFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllDelBgColor
        })
        document.querySelectorAll('.form-content .ad .el-button--warning').forEach(el=>{
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllWarnFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllWarnBgColor
        })
      })
    },
    // 表格
    // rowStyle({ row, rowIndex}) {
    //   if (rowIndex % 2 == 1) {
    //     if(this.contents.tableStripe) {
    //       return {color:this.contents.tableStripeFontColor}
    //     }
    //   } else {
    //     return ''
    //   }
    // },
    // cellStyle({ row, rowIndex}){
    //   if (rowIndex % 2 == 1) {
    //     if(this.contents.tableStripe) {
    //       return {backgroundColor:this.contents.tableStripeBgColor}
    //     }
    //   } else {
    //     return ''
    //   }
    // },
    headerRowStyle({ row, rowIndex}){
      return {color: this.contents.tableHeaderFontColor}
    },
    headerCellStyle({ row, rowIndex}){
      return {backgroundColor: this.contents.tableHeaderBgColor}
    },
    // 表格按钮
    contentTableBtnStyleChange(){

    },
    // 分页
    contentPageStyleChange(){
      let arr = []

      if(this.contents.pageTotal) arr.push('total')
      if(this.contents.pageSizes) arr.push('sizes')
      if(this.contents.pagePrevNext){
        arr.push('prev')
        if(this.contents.pagePager) arr.push('pager')
        arr.push('next')
      }
      if(this.contents.pageJumper) arr.push('jumper')
      this.layouts = arr.join()
      this.contents.pageEachNum = 10
    },

    init () {
        this.is_reviewedOptions = "是,否".split(',');
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
      }
          if(this.searchForm.is_reviewed!='' && this.searchForm.is_reviewed!=undefined){
            params['is_reviewed'] = this.searchForm.is_reviewed
          }
          if(this.searchForm.employee_name!='' && this.searchForm.employee_name!=undefined){
            params['employee_name'] = '%' + this.searchForm.employee_name + '%'
          }
          if(this.searchForm.is_reviewed!='' && this.searchForm.is_reviewed!=undefined){
            params['is_reviewed'] = this.searchForm.is_reviewed
          }
          if(this.searchForm.employer_name!='' && this.searchForm.employer_name!=undefined){
            params['employer_name'] = '%' + this.searchForm.employer_name + '%'
          }
      this.$http({
        url: "consult_employee/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    // 查看评论
    // 审核窗口
    shDialog(row){
      this.is_reviewedVisiable = !this.is_reviewedVisiable;
      if(row){
        this.shForm = {
          title: row.title,
          question: row.question,
          consult_time: row.consult_time,
          employee_account: row.employee_account,
          employee_name: row.employee_name,
          employer_account: row.employer_account,
          employer_name: row.employer_name,
          is_reviewed: row.is_reviewed,
          review_comment: row.review_comment,
          id: row.id
        }
      }
    },
    // 审核
    shHandler(){
      this.$confirm(`确定操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "consult_employee/update",
          method: "post",
          data: this.shForm
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.getDataList();
                this.shDialog()
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 删除
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "consult_employee/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },


  }

};
</script>
<style lang="scss" scoped>
.slt {
  margin: 0 !important;
  display: flex;
}

.ad {
  margin: 0 !important;
  display: flex;
}

.pages {
  & ::v-deep el-pagination__sizes {
    & ::v-deep el-input__inner {
      height: 22px;
      line-height: 22px;
    }
  }
}

.el-button + .el-button {
  margin: 0;
}

.tables {
  & ::v-deep .el-button--success {
    height: 40px;
    // color: #fff;
    font-size: 15px;
    border-width: 6px 0px 6px 0px;
    border-style: solid;
    border-color: #3bb78f;
    border-radius: 5px;
    background-color: #3bb78f;
    transition: background 0.3s;
    &:hover {
      background-color: #2fa77a;
    }
  }

  & ::v-deep .el-button--primary {
    height: 40px;
    color: #fff;
    font-size: 15px;
    border-width: 6px 0px 6px 0px;
    border-style: solid;
    border-color: #5ec6c6;
    border-radius: 5px;
    background-color: #5ec6c6;
    transition: background 0.3s;
    &:hover {
      background-color: #3bb78f;
    }
  }

  & ::v-deep .el-button--danger {
    height: 40px;
    color: #fff;
    font-size: 15px;
    border-width: 6px 0px 6px 0px;
    border-style: solid;
    border-color: #b8f2e6;
    border-radius: 5px;
    background-color: #b8f2e6;
    color: #3bb78f;
    transition: background 0.3s;
    &:hover {
      background-color: #3bb78f;
      color: #fff;
    }
  }

  & ::v-deep .el-button {
    margin: 4px;
  }
}

.form-content {
  background: transparent;
}
.table-content {
  background: transparent;
}

.tables ::v-deep .el-table__body tr {
  background-color: #f6fff8 !important;
}
.tables ::v-deep .el-table__body tr.el-table__row--striped td {
  background: transparent;
}


.tables ::v-deep .el-table__body tr:hover > td {
  background-color: #e0f7ef !important;
  color: #2574c7 !important;
}
</style>
