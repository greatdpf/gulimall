<template>
  <el-dialog
    :title="!dataForm.catId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="åˆ†ç±»åç§°" prop="name">
      <el-input v-model="dataForm.name" placeholder="åˆ†ç±»åç§°"></el-input>
    </el-form-item>
    <el-form-item label="çˆ¶åˆ†ç±»id" prop="parentCid">
      <el-input v-model="dataForm.parentCid" placeholder="çˆ¶åˆ†ç±»id"></el-input>
    </el-form-item>
    <el-form-item label="å±‚çº§" prop="catLevel">
      <el-input v-model="dataForm.catLevel" placeholder="å±‚çº§"></el-input>
    </el-form-item>
    <el-form-item label="æ˜¯å¦æ˜¾ç¤º[0-ä¸æ˜¾ç¤ºï¼Œ1æ˜¾ç¤º]" prop="showStatus">
      <el-input v-model="dataForm.showStatus" placeholder="æ˜¯å¦æ˜¾ç¤º[0-ä¸æ˜¾ç¤ºï¼Œ1æ˜¾ç¤º]"></el-input>
    </el-form-item>
    <el-form-item label="æŽ’åº" prop="sort">
      <el-input v-model="dataForm.sort" placeholder="æŽ’åº"></el-input>
    </el-form-item>
    <el-form-item label="å›¾æ ‡åœ°å€" prop="icon">
      <el-input v-model="dataForm.icon" placeholder="å›¾æ ‡åœ°å€"></el-input>
    </el-form-item>
    <el-form-item label="è®¡é‡å•ä½" prop="productUnit">
      <el-input v-model="dataForm.productUnit" placeholder="è®¡é‡å•ä½"></el-input>
    </el-form-item>
    <el-form-item label="å•†å“æ•°é‡" prop="productCount">
      <el-input v-model="dataForm.productCount" placeholder="å•†å“æ•°é‡"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          catId: 0,
          name: '',
          parentCid: '',
          catLevel: '',
          showStatus: '',
          sort: '',
          icon: '',
          productUnit: '',
          productCount: ''
        },
        dataRule: {
          name: [
            { required: true, message: 'åˆ†ç±»åç§°不能为空', trigger: 'blur' }
          ],
          parentCid: [
            { required: true, message: 'çˆ¶åˆ†ç±»id不能为空', trigger: 'blur' }
          ],
          catLevel: [
            { required: true, message: 'å±‚çº§不能为空', trigger: 'blur' }
          ],
          showStatus: [
            { required: true, message: 'æ˜¯å¦æ˜¾ç¤º[0-ä¸æ˜¾ç¤ºï¼Œ1æ˜¾ç¤º]不能为空', trigger: 'blur' }
          ],
          sort: [
            { required: true, message: 'æŽ’åº不能为空', trigger: 'blur' }
          ],
          icon: [
            { required: true, message: 'å›¾æ ‡åœ°å€不能为空', trigger: 'blur' }
          ],
          productUnit: [
            { required: true, message: 'è®¡é‡å•ä½不能为空', trigger: 'blur' }
          ],
          productCount: [
            { required: true, message: 'å•†å“æ•°é‡不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.catId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.catId) {
            this.$http({
              url: this.$http.adornUrl(`/product/category/info/${this.dataForm.catId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.category.name
                this.dataForm.parentCid = data.category.parentCid
                this.dataForm.catLevel = data.category.catLevel
                this.dataForm.showStatus = data.category.showStatus
                this.dataForm.sort = data.category.sort
                this.dataForm.icon = data.category.icon
                this.dataForm.productUnit = data.category.productUnit
                this.dataForm.productCount = data.category.productCount
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/product/category/${!this.dataForm.catId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'catId': this.dataForm.catId || undefined,
                'name': this.dataForm.name,
                'parentCid': this.dataForm.parentCid,
                'catLevel': this.dataForm.catLevel,
                'showStatus': this.dataForm.showStatus,
                'sort': this.dataForm.sort,
                'icon': this.dataForm.icon,
                'productUnit': this.dataForm.productUnit,
                'productCount': this.dataForm.productCount
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
