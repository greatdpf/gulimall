<template>
  <el-dialog
    :title="!dataForm.brandId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="å“ç‰Œå" prop="name">
      <el-input v-model="dataForm.name" placeholder="å“ç‰Œå"></el-input>
    </el-form-item>
    <el-form-item label="å“ç‰Œlogoåœ°å€" prop="logo">
      <el-input v-model="dataForm.logo" placeholder="å“ç‰Œlogoåœ°å€"></el-input>
    </el-form-item>
    <el-form-item label="ä»‹ç»" prop="descript">
      <el-input v-model="dataForm.descript" placeholder="ä»‹ç»"></el-input>
    </el-form-item>
    <el-form-item label="æ˜¾ç¤ºçŠ¶æ€[0-ä¸æ˜¾ç¤ºï¼›1-æ˜¾ç¤º]" prop="showStatus">
      <el-input v-model="dataForm.showStatus" placeholder="æ˜¾ç¤ºçŠ¶æ€[0-ä¸æ˜¾ç¤ºï¼›1-æ˜¾ç¤º]"></el-input>
    </el-form-item>
    <el-form-item label="æ£€ç´¢é¦–å­—æ¯" prop="firstLetter">
      <el-input v-model="dataForm.firstLetter" placeholder="æ£€ç´¢é¦–å­—æ¯"></el-input>
    </el-form-item>
    <el-form-item label="æŽ’åº" prop="sort">
      <el-input v-model="dataForm.sort" placeholder="æŽ’åº"></el-input>
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
          brandId: 0,
          name: '',
          logo: '',
          descript: '',
          showStatus: '',
          firstLetter: '',
          sort: ''
        },
        dataRule: {
          name: [
            { required: true, message: 'å“ç‰Œå不能为空', trigger: 'blur' }
          ],
          logo: [
            { required: true, message: 'å“ç‰Œlogoåœ°å€不能为空', trigger: 'blur' }
          ],
          descript: [
            { required: true, message: 'ä»‹ç»不能为空', trigger: 'blur' }
          ],
          showStatus: [
            { required: true, message: 'æ˜¾ç¤ºçŠ¶æ€[0-ä¸æ˜¾ç¤ºï¼›1-æ˜¾ç¤º]不能为空', trigger: 'blur' }
          ],
          firstLetter: [
            { required: true, message: 'æ£€ç´¢é¦–å­—æ¯不能为空', trigger: 'blur' }
          ],
          sort: [
            { required: true, message: 'æŽ’åº不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.brandId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.brandId) {
            this.$http({
              url: this.$http.adornUrl(`/product/brand/info/${this.dataForm.brandId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.brand.name
                this.dataForm.logo = data.brand.logo
                this.dataForm.descript = data.brand.descript
                this.dataForm.showStatus = data.brand.showStatus
                this.dataForm.firstLetter = data.brand.firstLetter
                this.dataForm.sort = data.brand.sort
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
              url: this.$http.adornUrl(`/product/brand/${!this.dataForm.brandId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'brandId': this.dataForm.brandId || undefined,
                'name': this.dataForm.name,
                'logo': this.dataForm.logo,
                'descript': this.dataForm.descript,
                'showStatus': this.dataForm.showStatus,
                'firstLetter': this.dataForm.firstLetter,
                'sort': this.dataForm.sort
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
