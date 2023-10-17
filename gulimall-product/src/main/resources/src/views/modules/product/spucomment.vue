<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('product:spucomment:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('product:spucomment:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;">
      <el-table-column
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>
      <el-table-column
        prop="id"
        header-align="center"
        align="center"
        label="id">
      </el-table-column>
      <el-table-column
        prop="skuId"
        header-align="center"
        align="center"
        label="sku_id">
      </el-table-column>
      <el-table-column
        prop="spuId"
        header-align="center"
        align="center"
        label="spu_id">
      </el-table-column>
      <el-table-column
        prop="spuName"
        header-align="center"
        align="center"
        label="å•†å“åå­—">
      </el-table-column>
      <el-table-column
        prop="memberNickName"
        header-align="center"
        align="center"
        label="ä¼šå‘˜æ˜µç§°">
      </el-table-column>
      <el-table-column
        prop="star"
        header-align="center"
        align="center"
        label="æ˜Ÿçº§">
      </el-table-column>
      <el-table-column
        prop="memberIp"
        header-align="center"
        align="center"
        label="ä¼šå‘˜ip">
      </el-table-column>
      <el-table-column
        prop="createTime"
        header-align="center"
        align="center"
        label="åˆ›å»ºæ—¶é—´">
      </el-table-column>
      <el-table-column
        prop="showStatus"
        header-align="center"
        align="center"
        label="æ˜¾ç¤ºçŠ¶æ€[0-ä¸æ˜¾ç¤ºï¼Œ1-æ˜¾ç¤º]">
      </el-table-column>
      <el-table-column
        prop="spuAttributes"
        header-align="center"
        align="center"
        label="è´­ä¹°æ—¶å±žæ€§ç»„åˆ">
      </el-table-column>
      <el-table-column
        prop="likesCount"
        header-align="center"
        align="center"
        label="ç‚¹èµžæ•°">
      </el-table-column>
      <el-table-column
        prop="replyCount"
        header-align="center"
        align="center"
        label="å›žå¤æ•°">
      </el-table-column>
      <el-table-column
        prop="resources"
        header-align="center"
        align="center"
        label="è¯„è®ºå›¾ç‰‡/è§†é¢‘[jsonæ•°æ®ï¼›[{type:æ–‡ä»¶ç±»åž‹,url:èµ„æºè·¯å¾„}]]">
      </el-table-column>
      <el-table-column
        prop="content"
        header-align="center"
        align="center"
        label="å†…å®¹">
      </el-table-column>
      <el-table-column
        prop="memberIcon"
        header-align="center"
        align="center"
        label="ç”¨æˆ·å¤´åƒ">
      </el-table-column>
      <el-table-column
        prop="commentType"
        header-align="center"
        align="center"
        label="è¯„è®ºç±»åž‹[0 - å¯¹å•†å“çš„ç›´æŽ¥è¯„è®ºï¼Œ1 - å¯¹è¯„è®ºçš„å›žå¤]">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.id)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="sizeChangeHandle"
      @current-change="currentChangeHandle"
      :current-page="pageIndex"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="pageSize"
      :total="totalPage"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
  </div>
</template>

<script>
  import AddOrUpdate from './spucomment-add-or-update'
  export default {
    data () {
      return {
        dataForm: {
          key: ''
        },
        dataList: [],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false,
        dataListSelections: [],
        addOrUpdateVisible: false
      }
    },
    components: {
      AddOrUpdate
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/product/spucomment/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'key': this.dataForm.key
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.page.list
            this.totalPage = data.page.totalCount
          } else {
            this.dataList = []
            this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },
      // 每页数
      sizeChangeHandle (val) {
        this.pageSize = val
        this.pageIndex = 1
        this.getDataList()
      },
      // 当前页
      currentChangeHandle (val) {
        this.pageIndex = val
        this.getDataList()
      },
      // 多选
      selectionChangeHandle (val) {
        this.dataListSelections = val
      },
      // 新增 / 修改
      addOrUpdateHandle (id) {
        this.addOrUpdateVisible = true
        this.$nextTick(() => {
          this.$refs.addOrUpdate.init(id)
        })
      },
      // 删除
      deleteHandle (id) {
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.id
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/product/spucomment/delete'),
            method: 'post',
            data: this.$http.adornData(ids, false)
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      }
    }
  }
</script>
